package co.edu.uniquindio.proyectoBases2.model;


import jakarta.persistence.Column;
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
    @Column(name = "id_tipo_evaluacion")
    private Integer idTipoEvaluacion;

    @Column(name = "codigo_tipo")
    private String codigoTipo;

    @Column(name = "nombre_tipo")
    private String nombreTipo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "costo_base")
    private Double costoBase;

    @Builder
    public TipoEvaluacionEspecial(Integer idTipoEvaluacion, String codigoTipo, String nombreTipo, String descripcion, Double costoBase) {
        this.idTipoEvaluacion = idTipoEvaluacion;
        this.codigoTipo = codigoTipo;
        this.nombreTipo = nombreTipo;
        this.descripcion = descripcion;
        this.costoBase = costoBase;
    }
}
