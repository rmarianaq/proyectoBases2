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
public class Calificacion {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_calificacion;

    private Integer id_matricula_detalle;
    private Integer id_regla;

    private Double nota;
    private LocalDateTime fecha_registro;
    private Integer id_profesor_registra;
    private String observaciones;

    @Builder
    public Calificacion(Integer id_calificacion, Integer id_matricula_detalle, Integer id_regla, Double nota, LocalDateTime fecha_registro, Integer id_profesor_registra, String observaciones) {
        this.id_calificacion = id_calificacion;
        this.id_matricula_detalle = id_matricula_detalle;
        this.id_regla = id_regla;
        this.nota = nota;
        this.fecha_registro = fecha_registro;
        this.id_profesor_registra = id_profesor_registra;
        this.observaciones = observaciones;
    }
}
