package co.edu.uniquindio.proyectoBases2.controllers;

import co.edu.uniquindio.proyectoBases2.model.Grupo;
import co.edu.uniquindio.proyectoBases2.model.HorarioGrupo;
import co.edu.uniquindio.proyectoBases2.model.ProfesorGrupo;
import co.edu.uniquindio.proyectoBases2.services.GrupoService;
import co.edu.uniquindio.proyectoBases2.services.HorarioGrupoService;
import co.edu.uniquindio.proyectoBases2.services.ProfesorGrupoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
@CrossOrigin("*")
public class GrupoController {

    private final GrupoService service;
    private final HorarioGrupoService horarioGrupoService;
    private final ProfesorGrupoService profesorGrupoService;

    public GrupoController(GrupoService service, HorarioGrupoService horarioGrupoService, ProfesorGrupoService profesorGrupoService) {
        this.service = service;
        this.horarioGrupoService = horarioGrupoService;
        this.profesorGrupoService = profesorGrupoService;
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

    @PostMapping("/{idGrupo}/horario")
    public HorarioGrupo crearHorario(
            @PathVariable Integer idGrupo,
            @RequestBody HorarioGrupo h) {

        h.setIdGrupo(idGrupo);
        return horarioGrupoService.crear(h);
    }

    @PostMapping("/{idGrupo}/profesor")
    public ProfesorGrupo asignarProfesor(
            @PathVariable Integer idGrupo,
            @RequestBody ProfesorGrupo pg) {

        pg.setIdGrupo(idGrupo);
        return profesorGrupoService.asignar(pg);
    }
}

