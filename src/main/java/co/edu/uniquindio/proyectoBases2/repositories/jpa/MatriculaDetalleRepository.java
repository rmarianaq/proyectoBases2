package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.MatriculaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatriculaDetalleRepository extends JpaRepository<MatriculaDetalle, Integer> {

    @Query("""
            SELECT COUNT(md)
            FROM MatriculaDetalle md
            WHERE md.idGrupo = :idGrupo
            """)
    Integer contarInscritos(Integer idGrupo);

    @Query("""
            SELECT SUM(a.creditos)
            FROM MatriculaDetalle md
            JOIN Grupo g ON md.idGrupo = g.idGrupo
            JOIN Asignatura a ON g.idAsignatura = a.idAsignatura
            WHERE md.idMatricula = :idMatricula
            """)
    Integer totalCreditos(Integer idMatricula);

    @Query("""
            SELECT md FROM MatriculaDetalle md
            WHERE md.idMatricula = :idMatricula
            """)
    List<MatriculaDetalle> detalles(Integer idMatricula);
}
