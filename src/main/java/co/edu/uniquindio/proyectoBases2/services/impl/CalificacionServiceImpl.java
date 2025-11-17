package co.edu.uniquindio.proyectoBases2.services.impl;

import co.edu.uniquindio.proyectoBases2.model.Calificacion;
import co.edu.uniquindio.proyectoBases2.model.NotaDefinitiva;
import co.edu.uniquindio.proyectoBases2.repositories.jpa.CalificacionRepository;
import co.edu.uniquindio.proyectoBases2.repositories.jpa.NotaDefinitivaRepository;
import co.edu.uniquindio.proyectoBases2.services.CalificacionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CalificacionServiceImpl implements CalificacionService {

    private final CalificacionRepository repo;
    private final NotaDefinitivaRepository notaRepo;

    public CalificacionServiceImpl(CalificacionRepository repo, NotaDefinitivaRepository notaRepo) {
        this.repo = repo;
        this.notaRepo = notaRepo;
    }

    @Override
    public Calificacion guardar(Calificacion c) {

        c.setFechaRegistro(LocalDateTime.now());
        Calificacion guardada = repo.save(c);

        Double definitiva = repo.calcularDefinitiva(c.getIdMatriculaDetalle());

        NotaDefinitiva nd = new NotaDefinitiva();
        nd.setIdMatriculaDetalle(c.getIdMatriculaDetalle());
        nd.setFechaCalculo(LocalDateTime.now());
        nd.setNotaDefinitiva(definitiva);
        nd.setAprobada(definitiva >= 3 ? "S" : "N");
        nd.setConsolidada("N");

        notaRepo.save(nd);

        return guardada;
    }
}
