package co.edu.uniquindio.proyectoBases2.services.impl;

import co.edu.uniquindio.proyectoBases2.model.HistorialRiesgoEstudiante;
import co.edu.uniquindio.proyectoBases2.model.NivelRiesgoAcademico;
import co.edu.uniquindio.proyectoBases2.repositories.jpa.HistorialRiesgoRepository;
import co.edu.uniquindio.proyectoBases2.repositories.jpa.NivelRiesgoAcademicoRepository;
import co.edu.uniquindio.proyectoBases2.services.RiesgoAcademicoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RiesgoAcademicoServiceImpl implements RiesgoAcademicoService {

    private final NivelRiesgoAcademicoRepository nivelRepo;
    private final HistorialRiesgoRepository historialRepo;

    public RiesgoAcademicoServiceImpl(NivelRiesgoAcademicoRepository nivelRepo,
                                      HistorialRiesgoRepository historialRepo) {
        this.nivelRepo = nivelRepo;
        this.historialRepo = historialRepo;
    }

    @Override
    public HistorialRiesgoEstudiante asignarRiesgo(
            Integer idEst,
            Integer idPeriodo,
            Double promedio,
            Integer perdidas) {

        NivelRiesgoAcademico nivel;

        if (promedio < 3 || perdidas >= 2)
            nivel = nivelRepo.findById(3).get(); // riesgo alto
        else if (promedio < 3.5)
            nivel = nivelRepo.findById(2).get(); // medio
        else
            nivel = nivelRepo.findById(1).get(); // bajo

        HistorialRiesgoEstudiante h = HistorialRiesgoEstudiante.builder()
                .idEstudiante(idEst)
                .idNivelRiesgo(nivel.getIdNivelRiesgo())
                .idPeriodo(idPeriodo)
                .fechaAsignacion(LocalDateTime.now())
                .promedioPeriodo(promedio)
                .materiasPerdidas(perdidas)
                .build();

        return historialRepo.save(h);
    }
}
