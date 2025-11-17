package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.HistorialRiesgoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HistorialRiesgoRepository extends JpaRepository<HistorialRiesgoEstudiante, Integer> {

    @Query("SELECT h FROM HistorialRiesgoEstudiante h WHERE h.idEstudiante = :idEstudiante")
    List<HistorialRiesgoEstudiante> buscarPorIdEstudiante(Integer idEstudiante);

    @Query("""
            SELECT h FROM HistorialRiesgoEstudiante h 
            WHERE h.idEstudiante = :idEstudiante 
            ORDER BY h.idHistorialRiesgo DESC
            """)
    Optional<HistorialRiesgoEstudiante> buscarUltimoPorEstudiante(Integer idEstudiante);

}
