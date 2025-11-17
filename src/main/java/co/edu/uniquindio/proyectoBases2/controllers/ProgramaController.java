package co.edu.uniquindio.proyectoBases2.controllers;

import co.edu.uniquindio.proyectoBases2.model.Programa;
import co.edu.uniquindio.proyectoBases2.services.ProgramaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programas")
@CrossOrigin("*")
public class ProgramaController {

    private final ProgramaService service;

    public ProgramaController(ProgramaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Programa> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Programa obtener(@PathVariable Integer id) { return service.obtener(id); }

    @PostMapping
    public Programa crear(@RequestBody Programa p) { return service.crear(p); }

    @PutMapping("/{id}")
    public Programa actualizar(@PathVariable Integer id, @RequestBody Programa p) {
        p.setIdPrograma(id);
        return service.actualizar(p);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) { service.eliminar(id); }
}
