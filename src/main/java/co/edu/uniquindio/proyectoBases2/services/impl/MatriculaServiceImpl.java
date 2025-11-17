package co.edu.uniquindio.proyectoBases2.services.impl;

import co.edu.uniquindio.proyectoBases2.model.*;
import co.edu.uniquindio.proyectoBases2.repositories.jpa.*;
import co.edu.uniquindio.proyectoBases2.services.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import co.edu.uniquindio.proyectoBases2.exceptions.BusinessException;
import java.time.LocalDate;

import java.util.Optional;

@Service
@Transactional
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepo;
    private final MatriculaDetalleRepository detalleRepo;
    private final GrupoRepository grupoRepo;
    private final AsignaturaRepository asignaturaRepo;
    private final PeriodoRepository periodoRepo;
    private final EstudianteRepository estudianteRepo;
    private final PrerrequisitoService prerrequisitoService;
    private final ReinscripcionService reinscripcionService;
    private final HistorialRiesgoRepository historialRiesgoRepo;
    private final NivelRiesgoAcademicoRepository nivelRiesgoRepo;
    private final GrupoService grupoService;
    private final AuditoriaService auditoriaService;

    public MatriculaServiceImpl(
            MatriculaRepository matriculaRepo,
            MatriculaDetalleRepository detalleRepo,
            GrupoRepository grupoRepo,
            AsignaturaRepository asignaturaRepo,
            PeriodoRepository periodoRepo,
            EstudianteRepository estudianteRepo,
            PrerrequisitoService prerrequisitoService,
            ReinscripcionService reinscripcionService,
            HistorialRiesgoRepository historialRiesgoRepo,
            NivelRiesgoAcademicoRepository nivelRiesgoRepo,
            GrupoService grupoService,
            AuditoriaService auditoriaService
    ) {
        this.matriculaRepo = matriculaRepo;
        this.detalleRepo = detalleRepo;
        this.grupoRepo = grupoRepo;
        this.asignaturaRepo = asignaturaRepo;
        this.periodoRepo = periodoRepo;
        this.estudianteRepo = estudianteRepo;
        this.prerrequisitoService = prerrequisitoService;
        this.reinscripcionService = reinscripcionService;
        this.historialRiesgoRepo = historialRiesgoRepo;
        this.nivelRiesgoRepo = nivelRiesgoRepo;
        this.grupoService = grupoService;
        this.auditoriaService = auditoriaService;
    }



    // ------------------------------------------------------------
    //                     CREAR MATRÍCULA
    // ------------------------------------------------------------
    @Override
    public Matricula crearMatricula(Matricula m) {

        // validar periodo
        Periodo p = periodoRepo.findById(m.getId_periodo())
                .orElseThrow(() -> new BusinessException("Periodo no existe"));

        LocalDate hoy = LocalDate.now();
        LocalDate inicio = p.getFecha_inicio_matriculas().toLocalDate();
        LocalDate fin = p.getFecha_fin_matriculas().toLocalDate();

        if (hoy.isBefore(inicio) || hoy.isAfter(fin)) {
            throw new BusinessException("Fuera de la ventana de matrícula");
        }

        // validar estudiante
        Estudiante est = estudianteRepo.findById(m.getId_estudiante())
                .orElseThrow(() -> new BusinessException("Estudiante no existe"));

        // datos base
        m.setFecha_matricula(LocalDateTime.now());
        m.setEstado_matricula("CREADA");

        Matricula matriculaGuardada = matriculaRepo.save(m);

        auditoriaService.registrar(
                "CREAR_MATRICULA",
                "Matrícula creada ID=" + matriculaGuardada.getId_matricula(),
                est.getCodigo_estudiante()
        );

        // 1er semestre → inscribir asignaturas base
        if (est.getSemestre_actual() != null && est.getSemestre_actual() == 1) {
            inscribirPrimerSemestreYPerdidas(matriculaGuardada, est);
        } else {
            reinscribirPerdidasSiCorresponde(matriculaGuardada, est);
        }

        return matriculaGuardada;
    }



    // ------------------------------------------------------------
    //                     AGREGAR ASIGNATURA
    // ------------------------------------------------------------
    @Override
    public String agregarAsignatura(Integer idMatricula, Integer idGrupo) {

        Matricula m = matriculaRepo.findById(idMatricula)
                .orElseThrow(() -> new BusinessException("Matrícula no encontrada"));

        Estudiante e = estudianteRepo.findById(m.getId_estudiante())
                .orElseThrow(() -> new BusinessException("Estudiante no encontrado"));

        Grupo g = grupoRepo.findById(idGrupo)
                .orElseThrow(() -> new BusinessException("Grupo no existe"));

        Asignatura a = asignaturaRepo.findById(g.getId_asignatura())
                .orElseThrow(() -> new BusinessException("Asignatura inválida"));

        // Validar prerrequisitos
        boolean ok = prerrequisitoService.cumplePrerrequisitos(e.getId_estudiante(), a.getId_asignatura());
        if (!ok)
            throw new BusinessException("No cumple prerrequisitos");

        // Validar límite de créditos por riesgo
        int limite = obtenerLimiteCreditos(e.getId_estudiante(), m.getId_periodo());
        Integer sumCred = detalleRepo.totalCreditos(idMatricula);
        sumCred = sumCred == null ? 0 : sumCred;

        if (sumCred + a.getCreditos() > limite)
            throw new BusinessException("Excede el límite de créditos (" + limite + ")");

        // Cupo
        if (!grupoService.tieneCupo(idGrupo))
            throw new BusinessException("Sin cupo disponible");

        // Choque
        List<MatriculaDetalle> detalles = detalleRepo.detalles(idMatricula);
        for (MatriculaDetalle md : detalles) {
            if ("ACTIVA".equalsIgnoreCase(md.getEstado_inscripcion())) {
                if (grupoService.hayChoque(md.getId_grupo(), idGrupo)) {
                    throw new BusinessException("Choque de horario");
                }
            }
        }

        // Registrar detalle
        MatriculaDetalle det = new MatriculaDetalle();
        det.setId_matricula(idMatricula);
        det.setId_grupo(idGrupo);
        det.setEstado_inscripcion("ACTIVA");
        det.setIntento_numero(1);
        detalleRepo.save(det);

        // Actualizar cupo
        g.setCupo_ocupado(g.getCupo_ocupado() == null ? 1 : g.getCupo_ocupado() + 1);
        grupoRepo.save(g);

        auditoriaService.registrar(
                "AGREGAR_ASIGNATURA",
                "Grupo " + idGrupo + " agregado a matrícula " + idMatricula,
                e.getCodigo_estudiante()
        );

        return "Asignatura agregada correctamente";
    }



    // ------------------------------------------------------------
    //                  LÍMITE DE CRÉDITOS
    // ------------------------------------------------------------
    @Override
    public int obtenerLimiteCreditos(Integer idEstudiante, Integer idPeriodo) {

        Optional<HistorialRiesgoEstudiante> ultimo =
                historialRiesgoRepo.findTopByIdEstudianteOrderByIdHistorialRiesgoDesc(idEstudiante);

        if (ultimo.isPresent()) {
            Integer nivel = ultimo.get().getId_nivel_riesgo();
            Optional<NivelRiesgoAcademico> n = nivelRiesgoRepo.findById(nivel);
            if (n.isPresent() && n.get().getCreditos_maximos() != null)
                return n.get().getCreditos_maximos();
        }

        // default
        return 21;
    }



    // ------------------------------------------------------------
    //          INSCRIPCIÓN PRIMER SEMESTRE + PERDIDAS
    // ------------------------------------------------------------
    private void inscribirPrimerSemestreYPerdidas(Matricula matricula, Estudiante est) {

        // 1. Traer todas las asignaturas del programa
        List<Asignatura> asignaturasPrograma =
                asignaturaRepo.asignaturasPorPrograma(est.getId_programa());

        // 2. Filtrar SOLO las de primer semestre
        List<Asignatura> iniciales = asignaturasPrograma.stream()
                .filter(a -> a.getSemestre_sugerido() != null && a.getSemestre_sugerido() == 1)
                .toList();

        if (iniciales.isEmpty()) {
            throw new BusinessException("No hay asignaturas definidas para el primer semestre");
        }

        // 3. Recorrer asignaturas de primer semestre
        for (Asignatura a : iniciales) {

            List<Grupo> grupos = grupoRepo.gruposPorAsignatura(a.getId_asignatura());

            Grupo grupoValido = grupos.stream()
                    .filter(g -> g.getId_periodo().equals(matricula.getId_periodo()))
                    .findFirst()
                    .orElse(null);

            if (grupoValido == null)
                throw new BusinessException(
                        "No hay grupo disponible en el periodo actual para " + a.getNombre_asignatura()
                );

            // 4. Inscribir asignatura
            agregarAsignatura(matricula.getId_matricula(), grupoValido.getId_grupo());
        }

        // 5. Reinscribir perdidas si aplica
        reinscribirPerdidasSiCorresponde(matricula, est);
    }


    // ------------------------------------------------------------
    //                REINSCRIPCIÓN DE PERDIDAS
    // ------------------------------------------------------------
    private void reinscribirPerdidasSiCorresponde(Matricula matricula, Estudiante est) {

        Integer periodoActual = matricula.getId_periodo();
        Integer periodoAnterior = periodoActual - 1;

        List<Integer> perdidas =
                reinscripcionService.obtenerMateriasPerdidas(est.getId_estudiante(), periodoAnterior);

        if (perdidas == null || perdidas.isEmpty())
            return;

        for (Integer idAsignatura : perdidas) {

            List<Grupo> grupos = grupoRepo.gruposPorAsignatura(idAsignatura);

            Grupo grupoParaInscribir = grupos.stream()
                    .filter(g -> g.getId_periodo().equals(matricula.getId_periodo()))
                    .findFirst()
                    .orElse(null);

            if (grupoParaInscribir == null) {
                auditoriaService.registrar(
                        "REINSCRIPCION_SIN_GRUPO",
                        "No hay grupo para asignatura " + idAsignatura,
                        est.getCodigo_estudiante()
                );
                continue;
            }

            try {
                agregarAsignatura(matricula.getId_matricula(), grupoParaInscribir.getId_grupo());

            } catch (BusinessException ex) {
                auditoriaService.registrar(
                        "REINSCRIPCION_FALLIDA",
                        "No se pudo reinscribir asignatura " + idAsignatura +
                        " -> " + ex.getMessage(),
                        est.getCodigo_estudiante()
                );
            }
        }
    }
}



