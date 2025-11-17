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
public class Estudiante {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_estudiante;
    private String codigo_estudiante;
    private String documento_identidad;

    private Integer id_tipo_documento;
    private String nombres;
    private String apellidos;
    private String email_institucional;
    private String telefono;
    private LocalDateTime fecha_ingreso;

    private Integer id_programa;
    private Integer id_sede;
    private Integer creditos_aprobados;
    private Double promedio_acumulado;
    private Integer semestre_actual;
    private String activo;

    @Builder
    public Estudiante(Integer id_estudiante, String codigo_estudiante, String documento_identidad, Integer id_tipo_documento, String nombres, String apellidos, String email_institucional, String telefono, LocalDateTime fecha_ingreso, Integer id_programa, Integer id_sede, Integer creditos_aprobados, Double promedio_acumulado, Integer semestre_actual, String activo) {
        this.id_estudiante = id_estudiante;
        this.codigo_estudiante = codigo_estudiante;
        this.documento_identidad = documento_identidad;
        this.id_tipo_documento = id_tipo_documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email_institucional = email_institucional;
        this.telefono = telefono;
        this.fecha_ingreso = fecha_ingreso;
        this.id_programa = id_programa;
        this.id_sede = id_sede;
        this.creditos_aprobados = creditos_aprobados;
        this.promedio_acumulado = promedio_acumulado;
        this.semestre_actual = semestre_actual;
        this.activo = activo;
    }
}
