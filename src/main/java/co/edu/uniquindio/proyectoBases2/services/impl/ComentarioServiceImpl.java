package co.edu.uniquindio.proyectoBases2.services.impl;

import co.edu.uniquindio.proyectoBases2.model.Comentario;
import co.edu.uniquindio.proyectoBases2.repositories.mongo.ComentarioMongoRepository;
import co.edu.uniquindio.proyectoBases2.services.ComentarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    private final ComentarioMongoRepository repo;

    public ComentarioServiceImpl(ComentarioMongoRepository repo) {
        this.repo = repo;
    }

    public Comentario guardar(Comentario c){
        return repo.save(c);
    }

    public List<Comentario> listarAsignatura(String id){
        return repo.findByIdAsignatura(id);
    }
}
