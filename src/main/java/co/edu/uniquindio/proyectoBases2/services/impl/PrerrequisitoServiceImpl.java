package co.edu.uniquindio.proyectoBases2.services.impl;

import co.edu.uniquindio.proyectoBases2.repositories.jpa.NotaDefinitivaRepository;
import co.edu.uniquindio.proyectoBases2.repositories.jpa.PrerrequisitoRepository;
import co.edu.uniquindio.proyectoBases2.services.PrerrequisitoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrerrequisitoServiceImpl implements PrerrequisitoService {

    private final PrerrequisitoRepository repo;
    private final NotaDefinitivaRepository notaRepo;

    public PrerrequisitoServiceImpl(PrerrequisitoRepository repo,
                                    NotaDefinitivaRepository notaRepo) {
        this.repo = repo;
        this.notaRepo = notaRepo;
    }

    @Override
    public boolean cumplePrerrequisitos(Integer idEstudiante, Integer idAsignatura) {

        List<Integer> prerrequisitos = repo.findPrerrequisitos(idAsignatura);

        for (Integer pre : prerrequisitos) {
            Boolean aprobado = notaRepo.aproboAsignatura(idEstudiante, pre);

            if (aprobado == null || !aprobado)
                return false;
        }

        return true;
    }
}

