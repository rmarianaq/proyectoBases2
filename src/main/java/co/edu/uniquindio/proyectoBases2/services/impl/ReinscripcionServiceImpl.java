package co.edu.uniquindio.proyectoBases2.services.impl;

import co.edu.uniquindio.proyectoBases2.repositories.jpa.NotaDefinitivaRepository;
import co.edu.uniquindio.proyectoBases2.services.ReinscripcionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReinscripcionServiceImpl implements ReinscripcionService {

    private final NotaDefinitivaRepository notaRepo;

    public ReinscripcionServiceImpl(NotaDefinitivaRepository notaRepo) {
        this.notaRepo = notaRepo;
    }

    @Override
    public List<Integer> obtenerMateriasPerdidas(Integer idEstudiante, Integer idPeriodo) {
        return notaRepo.obtenerReprobadas(idEstudiante, idPeriodo);
    }
}

