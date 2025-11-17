package co.edu.uniquindio.proyectoBases2.repositories.mongo;

import co.edu.uniquindio.proyectoBases2.model.Comentario;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ComentarioMongoRepository extends MongoRepository<Comentario, String> {

    List<Comentario> findByIdAsignatura(String idAsignatura);
    List<Comentario> findByIdPeriodo(String idPeriodo);
}

