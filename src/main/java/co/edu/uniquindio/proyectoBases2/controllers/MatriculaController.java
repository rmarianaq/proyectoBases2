package co.edu.uniquindio.proyectoBases2.controllers;

import co.edu.uniquindio.proyectoBases2.model.Matricula;
import co.edu.uniquindio.proyectoBases2.services.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matriculas")
@CrossOrigin("*")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Matricula> crear(@RequestBody Matricula m) {
        return ResponseEntity.ok(matriculaService.crearMatricula(m));
    }

    @PostMapping("/{idMatricula}/agregar/{idGrupo}")
    public ResponseEntity<String> agregar(
            @PathVariable Integer idMatricula,
            @PathVariable Integer idGrupo
    ) {
        return ResponseEntity.ok(matriculaService.agregarAsignatura(idMatricula, idGrupo));
    }

    @GetMapping("/limite-creditos")
    public ResponseEntity<Integer> limite(
            @RequestParam Integer idEstudiante,
            @RequestParam Integer idPeriodo
    ) {
        return ResponseEntity.ok(matriculaService.obtenerLimiteCreditos(idEstudiante, idPeriodo));
    }
}


