package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {

    @Query("""
            SELECT a FROM Asignatura a
            WHERE a.id_programa = :idPrograma
            """)
    List<Asignatura> asignaturasPorPrograma(Integer idPrograma);
}

