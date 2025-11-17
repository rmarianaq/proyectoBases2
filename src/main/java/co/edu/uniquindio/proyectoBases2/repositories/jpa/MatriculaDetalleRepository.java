package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.MatriculaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatriculaDetalleRepository extends JpaRepository<MatriculaDetalle, Integer> {

    @Query("""
            SELECT COUNT(md)
            FROM MatriculaDetalle md
            WHERE md.id_grupo = :idGrupo
            """)
    Integer contarInscritos(Integer idGrupo);

    @Query("""
            SELECT SUM(a.creditos)
            FROM MatriculaDetalle md
            JOIN Grupo g ON md.id_grupo = g.id_grupo
            JOIN Asignatura a ON g.id_asignatura = a.id_asignatura
            WHERE md.id_matricula = :idMatricula
            """)
    Integer totalCreditos(Integer idMatricula);

    @Query("""
            SELECT md FROM MatriculaDetalle md
            WHERE md.id_matricula = :idMatricula
            """)
    List<MatriculaDetalle> detalles(Integer idMatricula);
}
