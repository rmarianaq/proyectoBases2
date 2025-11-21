package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

    boolean existsByIdMatriculaDetalle(Integer idMatriculaDetalle);

    Comentario findByIdMatriculaDetalle(Integer idMatriculaDetalle);
}
