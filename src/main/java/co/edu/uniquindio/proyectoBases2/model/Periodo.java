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
public class Periodo {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_periodo")
    private Integer idPeriodo;

    @Column(name = "codigo_periodo")
    private String codigoPeriodo;

    @Column(name = "nombre_periodo")
    private String nombrePeriodo;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @Column(name = "fecha_inicio_matriculas")
    private LocalDateTime fechaInicioMatriculas;

    @Column(name = "fecha_fin_matriculas")
    private LocalDateTime fechaFinMatriculas;

    @Column(name = "fecha_cierre_notas")
    private LocalDateTime fechaCierreNotas;

    @Column(name = "activo")
    private String activo;

    @Builder
    public Periodo(Integer idPeriodo, String codigoPeriodo, String nombrePeriodo,
                   LocalDateTime fechaInicio, LocalDateTime fechaFin,
                   LocalDateTime fechaInicioMatriculas, LocalDateTime fechaFinMatriculas,
                   LocalDateTime fechaCierreNotas, String activo) {
        this.idPeriodo = idPeriodo;
        this.codigoPeriodo = codigoPeriodo;
        this.nombrePeriodo = nombrePeriodo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaInicioMatriculas = fechaInicioMatriculas;
        this.fechaFinMatriculas = fechaFinMatriculas;
        this.fechaCierreNotas = fechaCierreNotas;
        this.activo = activo;
    }
}
