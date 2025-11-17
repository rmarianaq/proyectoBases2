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
public class TipoRequisitoEspecial {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_tipo_requisito;
    private String codigo_tipo;
    private String nombre_tipo;
    private String descripcion;

    @Builder
    public TipoRequisitoEspecial(Integer id_tipo_requisito, String codigo_tipo, String nombre_tipo, String descripcion) {
        this.id_tipo_requisito = id_tipo_requisito;
        this.codigo_tipo = codigo_tipo;
        this.nombre_tipo = nombre_tipo;
        this.descripcion = descripcion;
    }
}
