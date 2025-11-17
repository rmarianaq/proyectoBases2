package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

    @Query("""
            SELECT m FROM Matricula m
            WHERE m.idEstudiante = :idEstudiante AND m.idPeriodo = :idPeriodo
            """)
    Optional<Matricula> buscarMatriculaEstudiante(Integer idEstudiante, Integer idPeriodo);
}
