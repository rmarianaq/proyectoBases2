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
public class Estudiante {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_estudiante")
    private Integer idEstudiante;

    @Column(name = "codigo_estudiante")
    private String codigoEstudiante;

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

    @Column(name = "fecha_ingreso")
    private LocalDateTime fechaIngreso;

    @Column(name = "id_programa")
    private Integer idPrograma;

    @Column(name = "id_sede")
    private Integer idSede;

    @Column(name = "creditos_aprobados")
    private Integer creditosAprobados;

    @Column(name = "promedio_acumulado")
    private Double promedioAcumulado;

    @Column(name = "semestre_actual")
    private Integer semestreActual;

    @Column(name = "activo")
    private String activo;

    @Builder
    public Estudiante(Integer idEstudiante, String codigoEstudiante, String documentoIdentidad,
                      Integer idTipoDocumento, String nombres, String apellidos,
                      String emailInstitucional, String telefono, LocalDateTime fechaIngreso,
                      Integer idPrograma, Integer idSede, Integer creditosAprobados,
                      Double promedioAcumulado, Integer semestreActual, String activo) {

        this.idEstudiante = idEstudiante;
        this.codigoEstudiante = codigoEstudiante;
        this.documentoIdentidad = documentoIdentidad;
        this.idTipoDocumento = idTipoDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.emailInstitucional = emailInstitucional;
        this.telefono = telefono;
        this.fechaIngreso = fechaIngreso;
        this.idPrograma = idPrograma;
        this.idSede = idSede;
        this.creditosAprobados = creditosAprobados;
        this.promedioAcumulado = promedioAcumulado;
        this.semestreActual = semestreActual;
        this.activo = activo;
    }
}

