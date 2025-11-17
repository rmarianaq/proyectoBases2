package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CalificacionRepository extends JpaRepository<Calificacion, Integer> {

    @Query("""
            SELECT SUM(c.nota * r.porcentaje / 100)
            FROM Calificacion c
            JOIN ReglaEvaluacion r ON c.idRegla = r.idRegla
            WHERE c.idMatriculaDetalle = :idDetalle
            """)
    Double calcularDefinitiva(Integer idDetalle);
}

