package co.edu.uniquindio.proyectoBases2.services;

import co.edu.uniquindio.proyectoBases2.model.ReglaEvaluacion;
import co.edu.uniquindio.proyectoBases2.repositories.jpa.GrupoRepository;
import co.edu.uniquindio.proyectoBases2.repositories.jpa.ReglaEvaluacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReglaEvaluacionService {

    private final ReglaEvaluacionRepository repo;
    private final GrupoRepository grupoRepo;

    public ReglaEvaluacionService(ReglaEvaluacionRepository repo, GrupoRepository grupoRepo) {
        this.repo = repo;
        this.grupoRepo = grupoRepo;
    }

    public ReglaEvaluacion crear(ReglaEvaluacion r) {

        // 1. validar grupo existe
        if (!grupoRepo.existsById(r.getId_grupo()))
            throw new RuntimeException("El grupo no existe.");

        // 2. validar porcentaje total
        Double total = repo.sumaPorcentajes(r.getId_grupo());
        if (total == null) total = 0.0;
        if (total + r.getPorcentaje() > 100.0)
            throw new RuntimeException("Los porcentajes superan 100%.");

        // 3. validar orden
        if (repo.existsByIdGrupoAndOrdenItem(r.getId_grupo(), r.getOrden_item()))
            throw new RuntimeException("El orden del ítem ya está asignado.");

        return repo.save(r);
    }

    public List<ReglaEvaluacion> listarPorGrupo(Integer idGrupo) {
        return repo.findByIdGrupo(idGrupo);
    }
}
