package co.edu.uniquindio.proyectoBases2.services.impl;

import co.edu.uniquindio.proyectoBases2.model.Estudiante;
import co.edu.uniquindio.proyectoBases2.repositories.jpa.EstudianteRepository;
import co.edu.uniquindio.proyectoBases2.services.EstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository repo;

    public EstudianteServiceImpl(EstudianteRepository repo) {
        this.repo = repo;
    }

    public Estudiante obtener(Integer id) { return repo.findById(id).orElseThrow(); }
    public List<Estudiante> listar() { return repo.findAll(); }
    public Estudiante crear(Estudiante e) { return repo.save(e); }
    public Estudiante actualizar(Estudiante e) { return repo.save(e); }
}
