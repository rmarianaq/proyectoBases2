package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.Prerrequisito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrerrequisitoRepository extends JpaRepository<Prerrequisito, Integer> {

    @Query("SELECT p.id_asignatura_prerequisito FROM Prerrequisito p WHERE p.id_asignatura = :idAsignatura")
    List<Integer> findPrerrequisitos(Integer idAsignatura);
}