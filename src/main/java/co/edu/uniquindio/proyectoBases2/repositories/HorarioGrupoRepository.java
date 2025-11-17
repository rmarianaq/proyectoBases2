package co.edu.uniquindio.proyectoBases2.repositories;

import co.edu.uniquindio.proyectoBases2.model.HorarioGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HorarioGrupoRepository extends JpaRepository<HorarioGrupo, Integer> {

    @Query("SELECT h FROM HorarioGrupo h WHERE h.id_grupo = :idGrupo")
    List<HorarioGrupo> obtenerHorario(Integer idGrupo);
}

