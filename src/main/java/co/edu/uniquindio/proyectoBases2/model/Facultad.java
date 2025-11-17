package co.edu.uniquindio.proyectoBases2.model;

import jakarta.persistence.Column;
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
    @Column(name = "id_facultad")
    private Integer idFacultad;

    @Column(name = "nombre_facultad")
    private String nombreFacultad;

    @Column(name = "id_decano")
    private Integer idDecano;

    @Column(name = "email_facultad")
    private String emailFacultad;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Builder
    public Facultad(Integer idFacultad, String nombreFacultad, Integer idDecano,
                    String emailFacultad, LocalDateTime fechaCreacion) {
        this.idFacultad = idFacultad;
        this.nombreFacultad = nombreFacultad;
        this.idDecano = idDecano;
        this.emailFacultad = emailFacultad;
        this.fechaCreacion = fechaCreacion;
    }
}
