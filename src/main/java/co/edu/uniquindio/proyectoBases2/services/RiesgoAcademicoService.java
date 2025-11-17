package co.edu.uniquindio.proyectoBases2.services;

import co.edu.uniquindio.proyectoBases2.model.HistorialRiesgoEstudiante;

public interface RiesgoAcademicoService {
    HistorialRiesgoEstudiante asignarRiesgo(
            Integer idEstudiante,
            Integer idPeriodo,
            Double promedio,
            Integer perdidas
    );
}