package co.edu.uniquindio.proyectoBases2.services.impl;

import co.edu.uniquindio.proyectoBases2.model.HistorialRiesgoEstudiante;
import co.edu.uniquindio.proyectoBases2.repositories.jpa.HistorialRiesgoRepository;
import co.edu.uniquindio.proyectoBases2.services.HistorialRiesgoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialRiesgoServiceImpl implements HistorialRiesgoService {

    private final HistorialRiesgoRepository repo;

    public HistorialRiesgoServiceImpl(HistorialRiesgoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<HistorialRiesgoEstudiante> obtenerHistorial(Integer id_estudiante) {
        return repo.buscarPorIdEstudiante(id_estudiante);
    }
}
