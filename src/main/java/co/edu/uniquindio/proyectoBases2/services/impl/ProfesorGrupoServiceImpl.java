package co.edu.uniquindio.proyectoBases2.services.impl;

import co.edu.uniquindio.proyectoBases2.model.Profesor;
import co.edu.uniquindio.proyectoBases2.model.ProfesorGrupo;
import co.edu.uniquindio.proyectoBases2.repositories.jpa.ProfesorGrupoRepository;
import co.edu.uniquindio.proyectoBases2.repositories.jpa.ProfesorRepository;
import co.edu.uniquindio.proyectoBases2.services.ProfesorGrupoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorGrupoServiceImpl implements ProfesorGrupoService {

    private final ProfesorGrupoRepository repo;
    private final ProfesorRepository profesorRepo;

    public ProfesorGrupoServiceImpl(ProfesorGrupoRepository repo,
                                    ProfesorRepository profesorRepo) {
        this.repo = repo;
        this.profesorRepo = profesorRepo;
    }

    @Override
    public ProfesorGrupo asignar(ProfesorGrupo pg) {

        Profesor profesor = profesorRepo.findById(pg.getIdProfesor())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        Integer horasActuales = repo.totalHorasAsignadas(pg.getIdProfesor());
        if (horasActuales == null) horasActuales = 0;

        if (horasActuales + pg.getHorasAsignadas() > profesor.getHorasMaximas())
            throw new RuntimeException("Supera horas máximas del profesor.");

        return repo.save(pg);
    }

    @Override
    public List<ProfesorGrupo> listarPorProfesor(Integer idProfesor) {
        return repo.findByIdProfesor(idProfesor);
    }
}
