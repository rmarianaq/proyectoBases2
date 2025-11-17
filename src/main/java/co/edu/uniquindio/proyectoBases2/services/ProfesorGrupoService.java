package co.edu.uniquindio.proyectoBases2.services;

import co.edu.uniquindio.proyectoBases2.model.ProfesorGrupo;

import java.util.List;

public interface ProfesorGrupoService {
    ProfesorGrupo asignar(ProfesorGrupo pg);
    List<ProfesorGrupo> listarPorProfesor(Integer idProfesor);
}