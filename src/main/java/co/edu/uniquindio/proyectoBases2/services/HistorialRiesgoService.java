package co.edu.uniquindio.proyectoBases2.services;

import co.edu.uniquindio.proyectoBases2.model.HistorialRiesgoEstudiante;

import java.util.List;

public interface HistorialRiesgoService {
    List<HistorialRiesgoEstudiante> obtenerHistorial(Integer idEstudiante);
}
