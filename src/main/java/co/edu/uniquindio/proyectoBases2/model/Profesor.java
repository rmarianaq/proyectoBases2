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
public class Profesor {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_profesor;
    private String documento_identidad;

    private Integer id_tipo_documento;
    private String nombres;
    private String apellidos;
    private String email_institucional;
    private String telefono;
    private LocalDateTime fecha_vinculacion;
    private Integer horas_minimas;
    private Integer horas_maximas;
    private String activo;

    @Builder
    public Profesor(Integer id_profesor, String documento_identidad, Integer id_tipo_documento, String nombres, String apellidos, String email_institucional, String telefono, LocalDateTime fecha_vinculacion, Integer horas_minimas, Integer horas_maximas, String activo) {
        this.id_profesor = id_profesor;
        this.documento_identidad = documento_identidad;
        this.id_tipo_documento = id_tipo_documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email_institucional = email_institucional;
        this.telefono = telefono;
        this.fecha_vinculacion = fecha_vinculacion;
        this.horas_minimas = horas_minimas;
        this.horas_maximas = horas_maximas;
        this.activo = activo;
    }
}

