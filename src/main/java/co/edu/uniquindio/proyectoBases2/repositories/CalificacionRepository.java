package co.edu.uniquindio.proyectoBases2.repositories;

import co.edu.uniquindio.proyectoBases2.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CalificacionRepository extends JpaRepository<Calificacion, Integer> {

    @Query("""
            SELECT SUM(c.nota * r.porcentaje / 100)
            FROM Calificacion c
            JOIN ReglaEvaluacion r ON c.id_regla = r.id_regla
            WHERE c.id_matricula_detalle = :idDetalle
            """)
    Double calcularDefinitiva(Integer idDetalle);
}

