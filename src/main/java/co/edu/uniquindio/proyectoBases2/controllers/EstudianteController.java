package co.edu.uniquindio.proyectoBases2.controllers;

import co.edu.uniquindio.proyectoBases2.model.Estudiante;
import co.edu.uniquindio.proyectoBases2.services.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin("*")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Estudiante> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Estudiante obtener(@PathVariable Integer id) { return service.obtener(id); }

    @PostMapping
    public Estudiante crear(@RequestBody Estudiante e) { return service.crear(e); }

    @PutMapping("/{id}")
    public Estudiante actualizar(@PathVariable Integer id, @RequestBody Estudiante e) {
        e.setId_estudiante(id);
        return service.actualizar(e);
    }
}


