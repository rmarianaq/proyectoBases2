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
public class ReglaEvaluacion {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_regla")
    private Integer idRegla;

    @Column(name = "id_grupo")
    private Integer idGrupo;

    @Column(name = "nombre_item")
    private String nombreItem;

    @Column(name = "porcentaje")
    private Double porcentaje;

    @Column(name = "orden_item")
    private Integer ordenItem;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @Column(name = "activa")
    private String activa;

    @Builder
    public ReglaEvaluacion(Integer idRegla, Integer idGrupo, String nombreItem, Double porcentaje, Integer ordenItem,
                           LocalDateTime fechaInicio, LocalDateTime fechaFin, String activa) {
        this.idRegla = idRegla;
        this.idGrupo = idGrupo;
        this.nombreItem = nombreItem;
        this.porcentaje = porcentaje;
        this.ordenItem = ordenItem;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.activa = activa;
    }
}
