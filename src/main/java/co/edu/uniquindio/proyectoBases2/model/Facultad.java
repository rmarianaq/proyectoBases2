package co.edu.uniquindio.proyectoBases2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Facultad {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_facultad;
    private String nombre_facultad;

    private Integer id_decano;
    private String email_facultad;
    private LocalDateTime fecha_creacion;

    @Builder
    public Facultad(Integer id_facultad, String nombre_facultad, Integer id_decano, String email_facultad, LocalDateTime fecha_creacion) {
        this.id_facultad = id_facultad;
        this.nombre_facultad = nombre_facultad;
        this.id_decano = id_decano;
        this.email_facultad = email_facultad;
        this.fecha_creacion = fecha_creacion;
    }
}
