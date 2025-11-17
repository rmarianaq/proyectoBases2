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
public class Periodo {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_periodo;
    private String codigo_periodo;
    private String nombre_periodo;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private LocalDateTime fecha_inicio_matriculas;
    private LocalDateTime fecha_fin_matriculas;
    private LocalDateTime fecha_cierre_notas;
    private String activo;

    @Builder
    public Periodo(Integer id_periodo, String codigo_periodo, String nombre_periodo, LocalDateTime fecha_inicio, LocalDateTime fecha_fin, LocalDateTime fecha_inicio_matriculas, LocalDateTime fecha_fin_matriculas, LocalDateTime fecha_cierre_notas, String activo) {
        this.id_periodo = id_periodo;
        this.codigo_periodo = codigo_periodo;
        this.nombre_periodo = nombre_periodo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fecha_inicio_matriculas = fecha_inicio_matriculas;
        this.fecha_fin_matriculas = fecha_fin_matriculas;
        this.fecha_cierre_notas = fecha_cierre_notas;
        this.activo = activo;
    }
}
