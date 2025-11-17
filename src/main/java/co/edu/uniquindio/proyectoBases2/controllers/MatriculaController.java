package co.edu.uniquindio.proyectoBases2.controllers;

import co.edu.uniquindio.proyectoBases2.model.Matricula;
import co.edu.uniquindio.proyectoBases2.services.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matriculas")
@CrossOrigin("*")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @PostMapping
    public Matricula crear(@RequestBody Matricula m) {
        return service.crear(m);
    }

    @PostMapping("/{idMatricula}/agregar/{idGrupo}")
    public ResponseEntity<String> agregarAsignatura(
            @PathVariable Integer idMatricula,
            @PathVariable Integer idGrupo) {
        return ResponseEntity.ok(service.agregarAsignatura(idMatricula, idGrupo));
    }
}

