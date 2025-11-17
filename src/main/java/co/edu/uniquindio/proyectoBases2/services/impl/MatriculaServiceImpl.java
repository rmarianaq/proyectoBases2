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
        Periodo p = periodoRepo.findById(m.getIdPeriodo())
                .orElseThrow(() -> new BusinessException("Periodo no existe"));

        LocalDate hoy = LocalDate.now();
        LocalDate inicio = p.getFechaInicioMatriculas().toLocalDate();
        LocalDate fin = p.getFechaFinMatriculas().toLocalDate();

        if (hoy.isBefore(inicio) || hoy.isAfter(fin)) {
            throw new BusinessException("Fuera de la ventana de matrícula");
        }

        // validar estudiante
        Estudiante est = estudianteRepo.findById(m.getIdEstudiante())
                .orElseThrow(() -> new BusinessException("Estudiante no existe"));

        // datos base
        m.setFechaMatricula(LocalDateTime.now());
        m.setEstadoMatricula("CREADA");

        Matricula matriculaGuardada = matriculaRepo.save(m);

        auditoriaService.registrar(
                "CREAR_MATRICULA",
                "Matrícula creada ID=" + matriculaGuardada.getIdMatricula(),
                est.getCodigoEstudiante()
        );

        // 1er semestre → inscribir asignaturas base
        if (est.getSemestreActual() != null && est.getSemestreActual() == 1) {
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

        Estudiante e = estudianteRepo.findById(m.getIdEstudiante())
                .orElseThrow(() -> new BusinessException("Estudiante no encontrado"));

        Grupo g = grupoRepo.findById(idGrupo)
                .orElseThrow(() -> new BusinessException("Grupo no existe"));

        Asignatura a = asignaturaRepo.findById(g.getIdAsignatura())
                .orElseThrow(() -> new BusinessException("Asignatura inválida"));

        // Validar prerrequisitos
        boolean ok = prerrequisitoService.cumplePrerrequisitos(e.getIdEstudiante(), a.getIdAsignatura());
        if (!ok)
            throw new BusinessException("No cumple prerrequisitos");

        // Validar límite de créditos por riesgo
        int limite = obtenerLimiteCreditos(e.getIdEstudiante(), m.getIdPeriodo());
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
            if ("ACTIVA".equalsIgnoreCase(md.getEstadoInscripcion())) {
                if (grupoService.hayChoque(md.getIdGrupo(), idGrupo)) {
                    throw new BusinessException("Choque de horario");
                }
            }
        }

        // Registrar detalle
        MatriculaDetalle det = new MatriculaDetalle();
        det.setIdMatricula(idMatricula);
        det.setIdGrupo(idGrupo);
        det.setEstadoInscripcion("ACTIVA");
        det.setIntentoNumero(1);
        detalleRepo.save(det);

        // Actualizar cupo
        g.setCupoOcupado(g.getCupoOcupado() == null ? 1 : g.getCupoOcupado() + 1);
        grupoRepo.save(g);

        auditoriaService.registrar(
                "AGREGAR_ASIGNATURA",
                "Grupo " + idGrupo + " agregado a matrícula " + idMatricula,
                e.getCodigoEstudiante()
        );

        return "Asignatura agregada correctamente";
    }



    // ------------------------------------------------------------
    //                  LÍMITE DE CRÉDITOS
    // ------------------------------------------------------------
    @Override
    public int obtenerLimiteCreditos(Integer idEstudiante, Integer idPeriodo) {

        Optional<HistorialRiesgoEstudiante> ultimo =
                historialRiesgoRepo.buscarUltimoPorEstudiante(idEstudiante);

        if (ultimo.isPresent()) {
            Integer nivel = ultimo.get().getIdNivelRiesgo();
            Optional<NivelRiesgoAcademico> n = nivelRiesgoRepo.findById(nivel);
            if (n.isPresent() && n.get().getCreditosMaximos() != null)
                return n.get().getCreditosMaximos();
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
                asignaturaRepo.asignaturasPorPrograma(est.getIdPrograma());

        // 2. Filtrar SOLO las de primer semestre
        List<Asignatura> iniciales = asignaturasPrograma.stream()
                .filter(a -> a.getSemestreSugerido() != null && a.getSemestreSugerido() == 1)
                .toList();

        if (iniciales.isEmpty()) {
            throw new BusinessException("No hay asignaturas definidas para el primer semestre");
        }

        // 3. Recorrer asignaturas de primer semestre
        for (Asignatura a : iniciales) {

            List<Grupo> grupos = grupoRepo.gruposPorAsignatura(a.getIdAsignatura());

            Grupo grupoValido = grupos.stream()
                    .filter(g -> g.getIdPeriodo().equals(matricula.getIdPeriodo()))
                    .findFirst()
                    .orElse(null);

            if (grupoValido == null)
                throw new BusinessException(
                        "No hay grupo disponible en el periodo actual para " + a.getNombreAsignatura()
                );

            // 4. Inscribir asignatura
            agregarAsignatura(matricula.getIdMatricula(), grupoValido.getIdGrupo());
        }

        // 5. Reinscribir perdidas si aplica
        reinscribirPerdidasSiCorresponde(matricula, est);
    }


    // ------------------------------------------------------------
    //                REINSCRIPCIÓN DE PERDIDAS
    // ------------------------------------------------------------
    private void reinscribirPerdidasSiCorresponde(Matricula matricula, Estudiante est) {

        Integer periodoActual = matricula.getIdPeriodo();
        Integer periodoAnterior = periodoActual - 1;

        List<Integer> perdidas =
                reinscripcionService.obtenerMateriasPerdidas(est.getIdEstudiante(), periodoAnterior);

        if (perdidas == null || perdidas.isEmpty())
            return;

        for (Integer idAsignatura : perdidas) {

            List<Grupo> grupos = grupoRepo.gruposPorAsignatura(idAsignatura);

            Grupo grupoParaInscribir = grupos.stream()
                    .filter(g -> g.getIdPeriodo().equals(matricula.getIdPeriodo()))
                    .findFirst()
                    .orElse(null);

            if (grupoParaInscribir == null) {
                auditoriaService.registrar(
                        "REINSCRIPCION_SIN_GRUPO",
                        "No hay grupo para asignatura " + idAsignatura,
                        est.getCodigoEstudiante()
                );
                continue;
            }

            try {
                agregarAsignatura(matricula.getIdMatricula(), grupoParaInscribir.getIdGrupo());

            } catch (BusinessException ex) {
                auditoriaService.registrar(
                        "REINSCRIPCION_FALLIDA",
                        "No se pudo reinscribir asignatura " + idAsignatura +
                        " -> " + ex.getMessage(),
                        est.getCodigoEstudiante()
                );
            }
        }
    }
}



