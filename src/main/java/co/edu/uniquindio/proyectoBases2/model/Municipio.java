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
public class Municipio {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_municipio;
    private String codigo_dane;
    private String nombre_municipio;

    @Builder
    public Municipio(Integer id_municipio, String codigo_dane, String nombre_municipio) {
        this.id_municipio = id_municipio;
        this.codigo_dane = codigo_dane;
        this.nombre_municipio = nombre_municipio;
    }
}
