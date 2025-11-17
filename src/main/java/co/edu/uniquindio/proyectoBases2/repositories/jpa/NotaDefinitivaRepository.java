package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.NotaDefinitiva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface NotaDefinitivaRepository extends JpaRepository<NotaDefinitiva, Integer> {

    @Query("""
    SELECT CASE WHEN n.aprobada = 'S' THEN TRUE ELSE FALSE END
    FROM NotaDefinitiva n
    WHERE n.idAsignatura = :idAsignatura
    AND n.idMatriculaDetalle IN (
        SELECT md.idMatriculaDetalle
        FROM MatriculaDetalle md
        WHERE md.idMatricula IN (
            SELECT m.idMatricula
            FROM Matricula m
            WHERE m.idEstudiante = :idEstudiante
        )
    )
""")
    Boolean aproboAsignatura(Integer idEstudiante, Integer idAsignatura);


    @Query("""
    SELECT n.idAsignatura
    FROM NotaDefinitiva n
    WHERE n.aprobada = 'N'
    AND n.idMatriculaDetalle IN (
        SELECT md.idMatriculaDetalle
        FROM MatriculaDetalle md
        WHERE md.idMatricula IN (
            SELECT m.idMatricula
            FROM Matricula m
            WHERE m.idEstudiante = :idEstudiante
            AND m.idPeriodo = :idPeriodo
        )
    )
""")
    List<Integer> obtenerReprobadas(Integer idEstudiante, Integer idPeriodo);


}

