package co.edu.uniquindio.proyectoBases2.repositories;

import co.edu.uniquindio.proyectoBases2.model.Profesor;
import co.edu.uniquindio.proyectoBases2.model.ProfesorGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfesorRepository extends JpaRepository<ProfesorGrupo, Integer> {

    @Query("""
            SELECT SUM(a.horas_semanales)
            FROM Grupo g
            JOIN Asignatura a ON g.id_asignatura = a.id_asignatura
            WHERE g.id_profesor = :idProfesor
            """)
    Integer horasAsignadas(Integer idProfesor);
}
