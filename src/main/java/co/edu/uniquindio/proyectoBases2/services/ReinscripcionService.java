package co.edu.uniquindio.proyectoBases2.services;

import java.util.List;

public interface ReinscripcionService {
    List<Integer> obtenerMateriasPerdidas(Integer idEstudiante, Integer idPeriodo);
}