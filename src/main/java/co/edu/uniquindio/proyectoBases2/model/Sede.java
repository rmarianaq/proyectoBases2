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
public class Sede {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_sede")
    private Integer idSede;

    @Column(name = "nombre_sede")
    private String nombreSede;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "id_municipio")
    private Integer idMunicipio;

    @Column(name = "activa")
    private String activa;

    @Builder
    public Sede(Integer idSede, String nombreSede, String direccion, String telefono, Integer idMunicipio, String activa) {
        this.idSede = idSede;
        this.nombreSede = nombreSede;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idMunicipio = idMunicipio;
        this.activa = activa;
    }
}
