package co.edu.uniquindio.proyectoBases2.services.impl;

import co.edu.uniquindio.proyectoBases2.model.Comentario;
import co.edu.uniquindio.proyectoBases2.model.ComentarioMongo;
import co.edu.uniquindio.proyectoBases2.repositories.jpa.ComentarioRepository;
import co.edu.uniquindio.proyectoBases2.repositories.mongo.ComentarioMongoRepository;
import co.edu.uniquindio.proyectoBases2.services.ComentarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComentarioServiceImpl implements ComentarioService {

    private final ComentarioRepository comentarioRepo;
    private final ComentarioMongoRepository comentarioMongoRepo;

    @Override
    public String crearComentario(Integer idMatriculaDetalle,
                                  String texto,
                                  Integer calificacionGeneral,
                                  List<String> etiquetas) {

        // 1. Guardar en Mongo
        ComentarioMongo nuevo = ComentarioMongo.builder()
                .idMatriculaDetalle(idMatriculaDetalle)
                .texto(texto)
                .calificacionGeneral(calificacionGeneral)
                .etiquetas(etiquetas)
                .estado("A")
                .fechaComentario(LocalDateTime.now())
                .build();

        nuevo = comentarioMongoRepo.save(nuevo);

        // 2. Guardar referencia en Oracle
        Comentario meta = Comentario.builder()
                .idMatriculaDetalle(idMatriculaDetalle)
                .idComentarioNosql(nuevo.getId())
                .migradoNosql("S")
                .anonimo("S")
                .build();

        comentarioRepo.save(meta);

        return nuevo.getId();
    }

    @Override
    public List<ComentarioMongo> listarComentariosPorMatricula(Integer idMatriculaDetalle) {
        return comentarioMongoRepo.findByIdMatriculaDetalle(idMatriculaDetalle);
    }
}
