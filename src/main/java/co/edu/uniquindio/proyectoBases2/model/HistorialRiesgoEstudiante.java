package co.edu.uniquindio.proyectoBases2.model;

import jakarta.persistence.Column;
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
    @Column(name = "id_historial_riesgo")
    private Integer idHistorialRiesgo;

    @Column(name = "id_estudiante")
    private Integer idEstudiante;

    @Column(name = "id_nivel_riesgo")
    private Integer idNivelRiesgo;

    @Column(name = "id_periodo")
    private Integer idPeriodo;

    @Column(name = "fecha_asignacion")
    private LocalDateTime fechaAsignacion;

    @Column(name = "promedio_periodo")
    private Double promedioPeriodo;

    @Column(name = "materias_perdidas")
    private Integer materiasPerdidas;

    @Column(name = "observaciones")
    private String observaciones;

    @Builder
    public HistorialRiesgoEstudiante(Integer idHistorialRiesgo, Integer idEstudiante,
                                     Integer idNivelRiesgo, Integer idPeriodo,
                                     LocalDateTime fechaAsignacion, Double promedioPeriodo,
                                     Integer materiasPerdidas, String observaciones) {

        this.idHistorialRiesgo = idHistorialRiesgo;
        this.idEstudiante = idEstudiante;
        this.idNivelRiesgo = idNivelRiesgo;
        this.idPeriodo = idPeriodo;
        this.fechaAsignacion = fechaAsignacion;
        this.promedioPeriodo = promedioPeriodo;
        this.materiasPerdidas = materiasPerdidas;
        this.observaciones = observaciones;
    }
}
