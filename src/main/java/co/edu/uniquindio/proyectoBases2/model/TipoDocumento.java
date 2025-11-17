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
public class TipoDocumento {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_Tipo_Documento")
    private Integer idTipoDocumento;

    @Column(name = "codigo_Tipo")
    private String codigoTipo;

    @Column(name = "nombre_Tipo")
    private String nombreTipo;

    @Column(name = "descripcion")
    private String descripcion;

    @Builder
    public TipoDocumento(Integer idTipoDocumento, String codigoTipo, String nombreTipo, String descripcion) {
        this.idTipoDocumento = idTipoDocumento;
        this.codigoTipo = codigoTipo;
        this.nombreTipo = nombreTipo;
        this.descripcion = descripcion;
    }
}

