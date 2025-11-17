package co.edu.uniquindio.proyectoBases2.controllers;

import co.edu.uniquindio.proyectoBases2.model.Asignatura;
import co.edu.uniquindio.proyectoBases2.services.AsignaturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
@CrossOrigin("*")
public class AsignaturaController {

    private final AsignaturaService service;

    public AsignaturaController(AsignaturaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Asignatura> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Asignatura obtener(@PathVariable Integer id) { return service.obtener(id); }

    @PostMapping
    public Asignatura crear(@RequestBody Asignatura a) { return service.crear(a); }

    @PutMapping("/{id}")
    public Asignatura actualizar(@PathVariable Integer id, @RequestBody Asignatura a) {
        a.setIdAsignatura(id);
        return service.actualizar(a);
    }
}

