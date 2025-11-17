package co.edu.uniquindio.proyectoBases2.controllers;

import co.edu.uniquindio.proyectoBases2.model.Grupo;
import co.edu.uniquindio.proyectoBases2.services.GrupoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
@CrossOrigin("*")
public class GrupoController {

    private final GrupoService service;

    public GrupoController(GrupoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Grupo> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Grupo obtener(@PathVariable Integer id) { return service.obtener(id); }

    @PostMapping
    public Grupo crear(@RequestBody Grupo g) { return service.crear(g); }

    @GetMapping("/{id}/cupo")
    public boolean hayCupo(@PathVariable Integer id) { return service.tieneCupo(id); }

    @GetMapping("/choque")
    public boolean choque(@RequestParam Integer g1, @RequestParam Integer g2) {
        return service.hayChoque(g1, g2);
    }
}

