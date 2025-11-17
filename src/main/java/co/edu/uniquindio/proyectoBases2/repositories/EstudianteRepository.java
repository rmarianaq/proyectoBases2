package co.edu.uniquindio.proyectoBases2.repositories;

import co.edu.uniquindio.proyectoBases2.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
}