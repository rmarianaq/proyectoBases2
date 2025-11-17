package co.edu.uniquindio.proyectoBases2.services;

import co.edu.uniquindio.proyectoBases2.model.Comentario;

import java.util.List;

public interface ComentarioService {
    Comentario guardar(Comentario c);
    List<Comentario> listarAsignatura(String idAsignatura);
}