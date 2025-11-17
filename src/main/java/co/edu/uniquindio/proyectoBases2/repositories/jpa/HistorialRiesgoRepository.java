package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.HistorialRiesgoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HistorialRiesgoRepository extends JpaRepository<HistorialRiesgoEstudiante, Integer> {

    List<HistorialRiesgoEstudiante> findByIdEstudiante(Integer idEstudiante);

    Optional<HistorialRiesgoEstudiante> findTopByIdEstudianteOrderByIdHistorialRiesgoDesc(Integer idEstudiante);
}
