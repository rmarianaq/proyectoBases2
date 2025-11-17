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
public class Salon {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_salon;
    private String codigo_salon;
    private String nombre_salon;
    private Integer capacidad_maxima;

    private Integer id_tipo_salon;
    private Integer id_sede;
    private String activo;

    @Builder
    public Salon(Integer id_salon, String codigo_salon, String nombre_salon, Integer capacidad_maxima, Integer id_tipo_salon, Integer id_sede, String activo) {
        this.id_salon = id_salon;
        this.codigo_salon = codigo_salon;
        this.nombre_salon = nombre_salon;
        this.capacidad_maxima = capacidad_maxima;
        this.id_tipo_salon = id_tipo_salon;
        this.id_sede = id_sede;
        this.activo = activo;
    }
}
