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
public class Matricula {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_matricula")
    private Integer idMatricula;

    @Column(name = "id_estudiante")
    private Integer idEstudiante;

    @Column(name = "id_periodo")
    private Integer idPeriodo;

    @Column(name = "fecha_matricula")
    private LocalDateTime fechaMatricula;

    @Column(name = "creditos_inscritos")
    private Integer creditosInscritos;

    @Column(name = "valor_matricula")
    private Double valorMatricula;

    @Column(name = "estado_matricula")
    private String estadoMatricula;

    @Column(name = "observaciones")
    private String observaciones;

    @Builder
    public Matricula(Integer idMatricula, Integer idEstudiante, Integer idPeriodo, LocalDateTime fechaMatricula,
                     Integer creditosInscritos, Double valorMatricula, String estadoMatricula, String observaciones) {
        this.idMatricula = idMatricula;
        this.idEstudiante = idEstudiante;
        this.idPeriodo = idPeriodo;
        this.fechaMatricula = fechaMatricula;
        this.creditosInscritos = creditosInscritos;
        this.valorMatricula = valorMatricula;
        this.estadoMatricula = estadoMatricula;
        this.observaciones = observaciones;
    }
}
