package co.edu.uniquindio.proyectoBases2.services;

import co.edu.uniquindio.proyectoBases2.model.Programa;

import java.util.List;

public interface ProgramaService {
    List<Programa> listar();
    Programa obtener(Integer id);
    Programa crear(Programa p);
    Programa actualizar(Programa p);
    void eliminar(Integer id);
}

