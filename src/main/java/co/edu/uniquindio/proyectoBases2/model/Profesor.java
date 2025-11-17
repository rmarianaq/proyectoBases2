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
public class Profesor {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_profesor")
    private Integer idProfesor;

    @Column(name = "documento_identidad")
    private String documentoIdentidad;

    @Column(name = "id_tipo_documento")
    private Integer idTipoDocumento;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "email_institucional")
    private String emailInstitucional;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fecha_vinculacion")
    private LocalDateTime fechaVinculacion;

    @Column(name = "horas_minimas")
    private Integer horasMinimas;

    @Column(name = "horas_maximas")
    private Integer horasMaximas;

    @Column(name = "activo")
    private String activo;

    @Builder
    public Profesor(Integer idProfesor, String documentoIdentidad, Integer idTipoDocumento, String nombres,
                    String apellidos, String emailInstitucional, String telefono,
                    LocalDateTime fechaVinculacion, Integer horasMinimas, Integer horasMaximas, String activo) {
        this.idProfesor = idProfesor;
        this.documentoIdentidad = documentoIdentidad;
        this.idTipoDocumento = idTipoDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.emailInstitucional = emailInstitucional;
        this.telefono = telefono;
        this.fechaVinculacion = fechaVinculacion;
        this.horasMinimas = horasMinimas;
        this.horasMaximas = horasMaximas;
        this.activo = activo;
    }
}

