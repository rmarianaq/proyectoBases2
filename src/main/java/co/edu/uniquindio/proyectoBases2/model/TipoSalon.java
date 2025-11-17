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
public class TipoSalon {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_tipo_salon;
    private String codigo_tipo;
    private String nombre_tipo;
    private String descripcion;

    @Builder
    public TipoSalon(Integer id_tipo_salon, String codigo_tipo, String nombre_tipo, String descripcion) {
        this.id_tipo_salon = id_tipo_salon;
        this.codigo_tipo = codigo_tipo;
        this.nombre_tipo = nombre_tipo;
        this.descripcion = descripcion;
    }
}
