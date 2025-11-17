package co.edu.uniquindio.proyectoBases2.services.impl;

import co.edu.uniquindio.proyectoBases2.model.Programa;
import co.edu.uniquindio.proyectoBases2.repositories.jpa.ProgramaRepository;
import co.edu.uniquindio.proyectoBases2.services.ProgramaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramaServiceImpl implements ProgramaService {

    private final ProgramaRepository repo;

    public ProgramaServiceImpl(ProgramaRepository repo) {
        this.repo = repo;
    }

    public List<Programa> listar() { return repo.findAll(); }

    public Programa obtener(Integer id) {
        return repo.findById(id).orElseThrow();
    }

    public Programa crear(Programa p) { return repo.save(p); }

    public Programa actualizar(Programa p) { return repo.save(p); }

    public void eliminar(Integer id) { repo.deleteById(id); }
}