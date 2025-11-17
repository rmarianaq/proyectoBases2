package co.edu.uniquindio.proyectoBases2.services;

import co.edu.uniquindio.proyectoBases2.model.HorarioGrupo;

import java.util.List;

public interface HorarioGrupoService {
    HorarioGrupo crear(HorarioGrupo h);
    List<HorarioGrupo> listarPorGrupo(Integer idGrupo);
}