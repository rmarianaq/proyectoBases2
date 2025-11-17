package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.ReglaEvaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReglaEvaluacionRepository extends JpaRepository<ReglaEvaluacion, Integer> {

    @Query("SELECT r FROM ReglaEvaluacion r WHERE r.id_grupo = :idGrupo")
    List<ReglaEvaluacion> reglasPorGrupo(Integer idGrupo);

    List<ReglaEvaluacion> findByIdGrupo(Integer idGrupo);

    @Query("""
            SELECT SUM(r.porcentaje)
            FROM ReglaEvaluacion r
            WHERE r.id_grupo = :idGrupo
            """)
    Double sumaPorcentajes(Integer idGrupo);

    boolean existsByIdGrupoAndOrdenItem(Integer idGrupo, Integer ordenItem);
}
