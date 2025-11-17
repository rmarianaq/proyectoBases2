package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {

    @Query("SELECT g FROM Grupo g WHERE g.idAsignatura = :idAsignatura")
    List<Grupo> gruposPorAsignatura(Integer idAsignatura);
}
