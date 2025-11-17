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
public class TipoPrograma {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_tipo_programa;
    private String codigo_tipo;
    private String nombre_tipo;
    private String descripcion;

    @Builder
    public TipoPrograma(Integer id_tipo_programa, String codigo_tipo, String nombre_tipo, String descripcion) {
        this.id_tipo_programa = id_tipo_programa;
        this.codigo_tipo = codigo_tipo;
        this.nombre_tipo = nombre_tipo;
        this.descripcion = descripcion;
    }
}
