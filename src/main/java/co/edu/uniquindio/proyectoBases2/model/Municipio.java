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
public class Municipio {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_municipio")
    private Integer idMunicipio;

    @Column(name = "codigo_dane")
    private String codigoDane;

    @Column(name = "nombre_municipio")
    private String nombreMunicipio;

    @Builder
    public Municipio(Integer idMunicipio, String codigoDane, String nombreMunicipio) {
        this.idMunicipio = idMunicipio;
        this.codigoDane = codigoDane;
        this.nombreMunicipio = nombreMunicipio;
    }
}
