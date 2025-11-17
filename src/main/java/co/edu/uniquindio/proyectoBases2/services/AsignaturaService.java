package co.edu.uniquindio.proyectoBases2.services;

import co.edu.uniquindio.proyectoBases2.model.Asignatura;

import java.util.List;

public interface AsignaturaService {
    Asignatura obtener(Integer id);
    List<Asignatura> listar();
    Asignatura crear(Asignatura a);
    Asignatura actualizar(Asignatura a);
}

