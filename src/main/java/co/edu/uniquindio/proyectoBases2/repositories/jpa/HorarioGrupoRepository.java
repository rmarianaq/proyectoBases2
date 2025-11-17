package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.HorarioGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HorarioGrupoRepository extends JpaRepository<HorarioGrupo, Integer> {

    @Query("SELECT h FROM HorarioGrupo h WHERE h.idGrupo = :idGrupo")
    List<HorarioGrupo> obtenerHorario(Integer idGrupo);

    List<HorarioGrupo> findByIdGrupo(Integer idGrupo);

    @Query("""
        SELECT h FROM HorarioGrupo h
        WHERE h.idSalon = :idSalon
        AND h.diaSemana = :dia
        AND (
            (h.horaInicio <= :horaFin AND h.horaFin >= :horaInicio)
        )
    """)
    List<HorarioGrupo> detectarChoqueSalon(
            Integer idSalon,
            String dia,
            String horaInicio,
            String horaFin
    );
}


