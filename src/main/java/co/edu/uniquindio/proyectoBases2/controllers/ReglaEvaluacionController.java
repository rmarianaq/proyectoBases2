package co.edu.uniquindio.proyectoBases2.controllers;

import co.edu.uniquindio.proyectoBases2.model.ReglaEvaluacion;
import co.edu.uniquindio.proyectoBases2.services.ReglaEvaluacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reglas")
@CrossOrigin("*")
public class ReglaEvaluacionController {

    private final ReglaEvaluacionService service;

    public ReglaEvaluacionController(ReglaEvaluacionService service) {
        this.service = service;
    }

    @PostMapping
    public ReglaEvaluacion crear(@RequestBody ReglaEvaluacion r) {
        return service.crear(r);
    }

    @GetMapping("/grupo/{id}")
    public List<ReglaEvaluacion> listar(@PathVariable Integer id) {
        return service.listarPorGrupo(id);
    }
}
