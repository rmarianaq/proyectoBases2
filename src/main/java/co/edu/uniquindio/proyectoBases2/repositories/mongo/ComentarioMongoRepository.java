package co.edu.uniquindio.proyectoBases2.repositories.mongo;

import co.edu.uniquindio.proyectoBases2.model.ComentarioMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ComentarioMongoRepository extends MongoRepository<ComentarioMongo, String> {

    List<ComentarioMongo> findByIdMatriculaDetalle(Integer idMatriculaDetalle);
}

