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
public class ReglaEvaluacion {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_regla;

    private Integer id_grupo;
    private String nombre_item;
    private Double porcentaje;
    private Integer orden_item;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private String activa;

    @Builder
    public ReglaEvaluacion(Integer id_regla, Integer id_grupo, String nombre_item, Double porcentaje, Integer orden_item, LocalDateTime fecha_inicio, LocalDateTime fecha_fin, String activa) {
        this.id_regla = id_regla;
        this.id_grupo = id_grupo;
        this.nombre_item = nombre_item;
        this.porcentaje = porcentaje;
        this.orden_item = orden_item;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.activa = activa;
    }
}
