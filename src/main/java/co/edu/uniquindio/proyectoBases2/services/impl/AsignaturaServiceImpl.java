package co.edu.uniquindio.proyectoBases2.services.impl;

import co.edu.uniquindio.proyectoBases2.model.Asignatura;
import co.edu.uniquindio.proyectoBases2.repositories.AsignaturaRepository;
import co.edu.uniquindio.proyectoBases2.services.AsignaturaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    private final AsignaturaRepository repo;

    public AsignaturaServiceImpl(AsignaturaRepository repo) {
        this.repo = repo;
    }

    public Asignatura obtener(Integer id){return repo.findById(id).orElseThrow();}
    public List<Asignatura> listar(){return repo.findAll();}
    public Asignatura crear(Asignatura a){return repo.save(a);}
    public Asignatura actualizar(Asignatura a){return repo.save(a);}
}
