package co.edu.uniquindio.proyectoBases2.services;

import co.edu.uniquindio.proyectoBases2.model.Matricula;

public interface MatriculaService {

    Matricula crearMatricula(Matricula matricula);

    String agregarAsignatura(Integer idMatricula, Integer idGrupo);

    int obtenerLimiteCreditos(Integer idEstudiante, Integer idPeriodo);
}


