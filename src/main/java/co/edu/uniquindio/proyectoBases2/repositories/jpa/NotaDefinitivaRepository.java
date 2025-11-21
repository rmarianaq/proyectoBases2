package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.NotaDefinitiva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface NotaDefinitivaRepository extends JpaRepository<NotaDefinitiva, Integer> {

    @Query("""
        SELECT CASE WHEN n.aprobada = 'S' THEN TRUE ELSE FALSE END
        FROM NotaDefinitiva n
        WHERE n.idMatriculaDetalle IN (
            SELECT md.idMatriculaDetalle
            FROM MatriculaDetalle md
            JOIN Grupo g ON g.idGrupo = md.idGrupo
            JOIN Matricula m ON m.idMatricula = md.idMatricula
            WHERE m.idEstudiante = :idEstudiante
            AND g.idAsignatura = :idAsignatura
        )
    """)
    Boolean aproboAsignatura(Integer idEstudiante, Integer idAsignatura);


    @Query("""
        SELECT g.idAsignatura
        FROM NotaDefinitiva n
        JOIN MatriculaDetalle md ON md.idMatriculaDetalle = n.idMatriculaDetalle
        JOIN Grupo g ON g.idGrupo = md.idGrupo
        JOIN Matricula m ON m.idMatricula = md.idMatricula
        WHERE n.aprobada = 'N'
        AND m.idEstudiante = :idEstudiante
        AND m.idPeriodo = :idPeriodo
    """)
    List<Integer> obtenerReprobadas(Integer idEstudiante, Integer idPeriodo);

}


