package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.NotaDefinitiva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface NotaDefinitivaRepository extends JpaRepository<NotaDefinitiva, Integer> {

    @Query("""
    SELECT CASE WHEN n.aprobada = 'S' THEN TRUE ELSE FALSE END
    FROM NotaDefinitiva n
    WHERE n.id_asignatura = :idAsignatura
    AND n.id_matricula_detalle IN (
        SELECT md.id_matricula_detalle
        FROM MatriculaDetalle md
        WHERE md.id_matricula IN (
            SELECT m.id_matricula
            FROM Matricula m
            WHERE m.id_estudiante = :idEstudiante
        )
    )
""")
    Boolean aproboAsignatura(Integer idEstudiante, Integer idAsignatura);


    @Query("""
    SELECT n.id_asignatura
    FROM NotaDefinitiva n
    WHERE n.aprobada = 'N'
    AND n.id_matricula_detalle IN (
        SELECT md.id_matricula_detalle
        FROM MatriculaDetalle md
        WHERE md.id_matricula IN (
            SELECT m.id_matricula
            FROM Matricula m
            WHERE m.id_estudiante = :idEstudiante
            AND m.id_periodo = :idPeriodo
        )
    )
""")
    List<Integer> obtenerReprobadas(Integer idEstudiante, Integer idPeriodo);


}

