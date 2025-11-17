package co.edu.uniquindio.proyectoBases2.controllers;

import co.edu.uniquindio.proyectoBases2.model.Estudiante;
import co.edu.uniquindio.proyectoBases2.model.HistorialRiesgoEstudiante;
import co.edu.uniquindio.proyectoBases2.services.EstudianteService;
import co.edu.uniquindio.proyectoBases2.services.HistorialRiesgoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin("*")
public class EstudianteController {

    private final EstudianteService service;
    private final HistorialRiesgoService historialRiesgoService;

    public EstudianteController(EstudianteService service, HistorialRiesgoService historialRiesgoService) {
        this.service = service;
        this.historialRiesgoService = historialRiesgoService;
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

    @GetMapping("/{id}/riesgo")
    public List<HistorialRiesgoEstudiante> riesgo(@PathVariable Integer id) {
        return historialRiesgoService.obtenerHistorial(id);
    }
}


