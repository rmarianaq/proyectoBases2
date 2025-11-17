package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.ProfesorGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfesorGrupoRepository extends JpaRepository<ProfesorGrupo, Integer> {

    List<ProfesorGrupo> findByIdProfesor(Integer idProfesor);

    @Query("SELECT SUM(p.horasAsignadas) FROM ProfesorGrupo p WHERE p.idProfesor = :idProfesor")
    Integer totalHorasAsignadas(Integer idProfesor);
}