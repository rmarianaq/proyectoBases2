package co.edu.uniquindio.proyectoBases2.controllers;

import co.edu.uniquindio.proyectoBases2.model.Calificacion;
import co.edu.uniquindio.proyectoBases2.services.CalificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calificaciones")
@CrossOrigin("*")
public class CalificacionController {

    private final CalificacionService service;

    public CalificacionController(CalificacionService service) {
        this.service = service;
    }

    @PostMapping
    public Calificacion guardar(@RequestBody Calificacion c) {
        return service.guardar(c);
    }
}


