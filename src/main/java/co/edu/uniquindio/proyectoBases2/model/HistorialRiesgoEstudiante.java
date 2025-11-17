package co.edu.uniquindio.proyectoBases2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class HistorialRiesgoEstudiante {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_historial_Riesgo;

    private Integer id_estudiante;
    private Integer id_nivel_riesgo;
    private Integer id_periodo;
    private LocalDateTime fecha_asignacion;
    private Double promedio_periodo;
    private Integer materias_perdidas;
    private String observaciones;

    @Builder
    public HistorialRiesgoEstudiante(Integer id_historial_Riesgo, Integer id_estudiante, Integer id_nivel_riesgo, Integer id_periodo, LocalDateTime fecha_asignacion, Double promedio_periodo, Integer materias_perdidas, String observaciones) {
        this.id_historial_Riesgo = id_historial_Riesgo;
        this.id_estudiante = id_estudiante;
        this.id_nivel_riesgo = id_nivel_riesgo;
        this.id_periodo = id_periodo;
        this.fecha_asignacion = fecha_asignacion;
        this.promedio_periodo = promedio_periodo;
        this.materias_perdidas = materias_perdidas;
        this.observaciones = observaciones;
    }
}
