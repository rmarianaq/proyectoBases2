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
public class Sede {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_sede;
    private String nombre_sede;
    private String direccion;
    private String telefono;

    private Integer id_municipio;
    private String activa;

    @Builder
    public Sede(Integer id_sede, String nombre_sede, String direccion, String telefono, Integer id_municipio, String activa) {
        this.id_sede = id_sede;
        this.nombre_sede = nombre_sede;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id_municipio = id_municipio;
        this.activa = activa;
    }
}
