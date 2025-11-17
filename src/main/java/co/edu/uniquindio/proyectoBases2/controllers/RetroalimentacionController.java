package co.edu.uniquindio.proyectoBases2.controllers;

import co.edu.uniquindio.proyectoBases2.model.Comentario;
import co.edu.uniquindio.proyectoBases2.services.ComentarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
@CrossOrigin("*")
public class RetroalimentacionController {

    private final ComentarioService service;

    public RetroalimentacionController(ComentarioService service) {
        this.service = service;
    }

    @PostMapping
    public Comentario guardar(@RequestBody Comentario c) {
        return service.guardar(c);
    }

    @GetMapping("/asignatura/{id}")
    public List<Comentario> porAsignatura(@PathVariable String id) {
        return service.listarAsignatura(id);
    }
}
