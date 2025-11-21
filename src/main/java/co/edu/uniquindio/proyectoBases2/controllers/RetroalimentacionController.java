package co.edu.uniquindio.proyectoBases2.controllers;

import co.edu.uniquindio.proyectoBases2.model.ComentarioMongo;
import co.edu.uniquindio.proyectoBases2.services.ComentarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/comentarios")
@RequiredArgsConstructor
public class RetroalimentacionController {

    private final ComentarioService comentarioService;

    @PostMapping("/crear")
    public ResponseEntity<?> crearComentario(@RequestBody ComentarioMongo comentarioMongo) {

        String id = comentarioService.crearComentario(
                comentarioMongo.getIdMatriculaDetalle(),
                comentarioMongo.getTexto(),
                comentarioMongo.getCalificacionGeneral(),
                comentarioMongo.getEtiquetas()
        );

        return ResponseEntity.ok("Comentario creado con ID Mongo: " + id);
    }

    @GetMapping("/{idMatriculaDetalle}")
    public ResponseEntity<?> listar(@PathVariable Integer idMatriculaDetalle) {
        return ResponseEntity.ok(
                comentarioService.listarComentariosPorMatricula(idMatriculaDetalle)
        );
    }
}

