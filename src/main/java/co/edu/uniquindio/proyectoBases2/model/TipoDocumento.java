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
public class TipoDocumento {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_Tipo_Documento;
    private String codigo_Tipo;
    private String nombre_Tipo;
    private String descripcion;

    @Builder
    public TipoDocumento(Integer id_Tipo_Documento, String codigo_Tipo, String nombre_Tipo, String descripcion) {
        this.id_Tipo_Documento = id_Tipo_Documento;
        this.codigo_Tipo = codigo_Tipo;
        this.nombre_Tipo = nombre_Tipo;
        this.descripcion = descripcion;
    }
}
