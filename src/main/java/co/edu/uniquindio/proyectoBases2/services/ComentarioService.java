package co.edu.uniquindio.proyectoBases2.services;

import co.edu.uniquindio.proyectoBases2.model.ComentarioMongo;

import java.util.List;

public interface ComentarioService {

    String crearComentario(Integer idMatriculaDetalle,
                           String texto,
                           Integer calificacionGeneral,
                           List<String> etiquetas);

    List<ComentarioMongo> listarComentariosPorMatricula(Integer idMatriculaDetalle);
}
