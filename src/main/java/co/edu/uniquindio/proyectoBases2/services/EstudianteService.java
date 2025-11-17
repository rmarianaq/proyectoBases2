package co.edu.uniquindio.proyectoBases2.services;

import co.edu.uniquindio.proyectoBases2.model.Estudiante;

import java.util.List;

public interface EstudianteService {
    Estudiante obtener(Integer id);
    List<Estudiante> listar();
    Estudiante crear(Estudiante e);
    Estudiante actualizar(Estudiante e);
}