package co.edu.uniquindio.proyectoBases2.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class TipoEvaluacionEspecial {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_tipo_evaluacion;
    private String codigo_tipo;
    private String nombre_tipo;
    private String descripcion;
    private Double costo_base;

    @Builder
    public TipoEvaluacionEspecial(Integer id_tipo_evaluacion, String codigo_tipo, String nombre_tipo, String descripcion, Double costo_base) {
        this.id_tipo_evaluacion = id_tipo_evaluacion;
        this.codigo_tipo = codigo_tipo;
        this.nombre_tipo = nombre_tipo;
        this.descripcion = descripcion;
        this.costo_base = costo_base;
    }
}
