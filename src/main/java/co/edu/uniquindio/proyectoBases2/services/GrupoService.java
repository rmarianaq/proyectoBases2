package co.edu.uniquindio.proyectoBases2.services;

import co.edu.uniquindio.proyectoBases2.model.Grupo;

import java.util.List;

public interface GrupoService {
    Grupo obtener(Integer id);
    List<Grupo> listar();
    Grupo crear(Grupo g);
    boolean tieneCupo(Integer idGrupo);
    boolean hayChoque(Integer idGrupo1, Integer idGrupo2);
}


