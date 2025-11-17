package co.edu.uniquindio.proyectoBases2.services.impl;


import co.edu.uniquindio.proyectoBases2.model.*;
import co.edu.uniquindio.proyectoBases2.repositories.*;

import co.edu.uniquindio.proyectoBases2.services.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepo;
    private final MatriculaDetalleRepository detalleRepo;
    private final GrupoRepository grupoRepo;
    private final HorarioGrupoRepository horarioRepo;
    private final AsignaturaRepository asignaturaRepo;
    private final EstudianteRepository estudianteRepo;

    public MatriculaServiceImpl(
            MatriculaRepository matriculaRepo,
            MatriculaDetalleRepository detalleRepo,
            GrupoRepository grupoRepo,
            HorarioGrupoRepository horarioRepo,
            AsignaturaRepository asignaturaRepo,
            EstudianteRepository estudianteRepo) {
        this.matriculaRepo = matriculaRepo;
        this.detalleRepo = detalleRepo;
        this.grupoRepo = grupoRepo;
        this.horarioRepo = horarioRepo;
        this.asignaturaRepo = asignaturaRepo;
        this.estudianteRepo = estudianteRepo;
    }

    @Override
    public Matricula crear(Matricula m) {
        m.setFecha_matricula(LocalDateTime.now());
        return matriculaRepo.save(m);
    }

    @Override
    public String agregarAsignatura(Integer idMatricula, Integer idGrupo) {

        Matricula matricula = matriculaRepo.findById(idMatricula).orElseThrow();
        Grupo grupo = grupoRepo.findById(idGrupo).orElseThrow();

        // validación cupo
        if (grupo.getCupo_ocupado() >= grupo.getCupo_maximo()) {
            return "Cupo lleno";
        }

        // registro detalle
        MatriculaDetalle md = new MatriculaDetalle();
        md.setId_matricula(idMatricula);
        md.setId_grupo(idGrupo);
        md.setEstado_inscripcion("ACTIVA");
        md.setIntento_numero(1);

        detalleRepo.save(md);

        // actualizar cupo
        grupo.setCupo_ocupado(grupo.getCupo_ocupado() + 1);
        grupoRepo.save(grupo);

        return "Asignatura agregada";
    }
}

