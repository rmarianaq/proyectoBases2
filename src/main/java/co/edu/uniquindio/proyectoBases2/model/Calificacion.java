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
public class Calificacion {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_calificacion")
    private Integer idCalificacion;

    @Column(name = "id_matricula_detalle")
    private Integer idMatriculaDetalle;

    @Column(name = "id_regla")
    private Integer idRegla;

    @Column(name = "nota")
    private Double nota;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "id_profesor_registra")
    private Integer idProfesorRegistra;

    @Column(name = "observaciones")
    private String observaciones;

    @Builder
    public Calificacion(Integer idCalificacion, Integer idMatriculaDetalle, Integer idRegla,
                        Double nota, LocalDateTime fechaRegistro, Integer idProfesorRegistra,
                        String observaciones) {
        this.idCalificacion = idCalificacion;
        this.idMatriculaDetalle = idMatriculaDetalle;
        this.idRegla = idRegla;
        this.nota = nota;
        this.fechaRegistro = fechaRegistro;
        this.idProfesorRegistra = idProfesorRegistra;
        this.observaciones = observaciones;
    }
}
