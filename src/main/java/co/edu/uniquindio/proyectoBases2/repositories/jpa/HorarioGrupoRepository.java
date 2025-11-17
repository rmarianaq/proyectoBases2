package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.HorarioGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HorarioGrupoRepository extends JpaRepository<HorarioGrupo, Integer> {

    @Query("SELECT h FROM HorarioGrupo h WHERE h.id_grupo = :idGrupo")
    List<HorarioGrupo> obtenerHorario(Integer idGrupo);

    List<HorarioGrupo> findByIdGrupo(Integer idGrupo);

    @Query("""
        SELECT h FROM HorarioGrupo h
        WHERE h.id_salon = :idSalon
        AND h.dia_semana = :dia
        AND (
            (h.hora_inicio <= :horaFin AND h.hora_fin >= :horaInicio)
        )
    """)
    List<HorarioGrupo> detectarChoqueSalon(
            Integer idSalon,
            String dia,
            String horaInicio,
            String horaFin
    );
}


