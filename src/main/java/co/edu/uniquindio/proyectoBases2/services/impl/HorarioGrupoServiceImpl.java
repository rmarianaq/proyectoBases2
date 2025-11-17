package co.edu.uniquindio.proyectoBases2.services.impl;

import co.edu.uniquindio.proyectoBases2.model.HorarioGrupo;
import co.edu.uniquindio.proyectoBases2.repositories.jpa.GrupoRepository;
import co.edu.uniquindio.proyectoBases2.repositories.jpa.HorarioGrupoRepository;
import co.edu.uniquindio.proyectoBases2.services.HorarioGrupoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioGrupoServiceImpl implements HorarioGrupoService {

    private final HorarioGrupoRepository repo;
    private final GrupoRepository grupoRepo;

    public HorarioGrupoServiceImpl(HorarioGrupoRepository repo,
                                   GrupoRepository grupoRepo) {
        this.repo = repo;
        this.grupoRepo = grupoRepo;
    }

    @Override
    public HorarioGrupo crear(HorarioGrupo h) {

        if (!grupoRepo.existsById(h.getId_grupo()))
            throw new RuntimeException("El grupo no existe.");

        if (h.getHora_inicio().compareTo(h.getHora_fin()) >= 0)
            throw new RuntimeException("Hora inicio debe ser menor a hora fin.");

        List<HorarioGrupo> choque = repo.detectarChoqueSalon(
                h.getId_salon(),
                h.getDia_semana(),
                h.getHora_inicio(),
                h.getHora_fin()
        );

        if (!choque.isEmpty())
            throw new RuntimeException("El salón ya está ocupado.");

        return repo.save(h);
    }

    @Override
    public List<HorarioGrupo> listarPorGrupo(Integer idGrupo) {
        return repo.findByIdGrupo(idGrupo);
    }
}
