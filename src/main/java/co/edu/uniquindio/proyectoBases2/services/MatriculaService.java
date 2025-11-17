package co.edu.uniquindio.proyectoBases2.services;

import co.edu.uniquindio.proyectoBases2.model.Matricula;

public interface MatriculaService {
    Matricula crear(Matricula m);
    String agregarAsignatura(Integer idMatricula, Integer idGrupo);
}

