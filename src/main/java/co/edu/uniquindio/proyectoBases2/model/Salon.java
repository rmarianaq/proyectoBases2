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
public class Salon {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_salon")
    private Integer idSalon;

    @Column(name = "codigo_salon")
    private String codigoSalon;

    @Column(name = "nombre_salon")
    private String nombreSalon;

    @Column(name = "capacidad_maxima")
    private Integer capacidadMaxima;

    @Column(name = "id_tipo_salon")
    private Integer idTipoSalon;

    @Column(name = "id_sede")
    private Integer idSede;

    @Column(name = "activo")
    private String activo;

    @Builder
    public Salon(Integer idSalon, String codigoSalon, String nombreSalon, Integer capacidadMaxima,
                 Integer idTipoSalon, Integer idSede, String activo) {
        this.idSalon = idSalon;
        this.codigoSalon = codigoSalon;
        this.nombreSalon = nombreSalon;
        this.capacidadMaxima = capacidadMaxima;
        this.idTipoSalon = idTipoSalon;
        this.idSede = idSede;
        this.activo = activo;
    }
}
