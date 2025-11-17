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
public class TipoSalon {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_tipo_salon")
    private Integer idTipoSalon;

    @Column(name = "codigo_tipo")
    private String codigoTipo;

    @Column(name = "nombre_tipo")
    private String nombreTipo;

    @Column(name = "descripcion")
    private String descripcion;

    @Builder
    public TipoSalon(Integer idTipoSalon, String codigoTipo, String nombreTipo, String descripcion) {
        this.idTipoSalon = idTipoSalon;
        this.codigoTipo = codigoTipo;
        this.nombreTipo = nombreTipo;
        this.descripcion = descripcion;
    }
}

