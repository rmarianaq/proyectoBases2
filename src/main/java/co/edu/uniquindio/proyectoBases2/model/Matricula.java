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
public class Matricula {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_matricula;

    private Integer id_estudiante;
    private Integer id_periodo;
    private LocalDateTime fecha_matricula;
    private Integer creditos_inscritos;
    private Double valor_matricula;
    private String estado_matricula;
    private String observaciones;

    @Builder
    public Matricula(Integer id_matricula, Integer id_estudiante, Integer id_periodo, LocalDateTime fecha_matricula, Integer creditos_inscritos, Double valor_matricula, String estado_matricula, String observaciones) {
        this.id_matricula = id_matricula;
        this.id_estudiante = id_estudiante;
        this.id_periodo = id_periodo;
        this.fecha_matricula = fecha_matricula;
        this.creditos_inscritos = creditos_inscritos;
        this.valor_matricula = valor_matricula;
        this.estado_matricula = estado_matricula;
        this.observaciones = observaciones;
    }
}
