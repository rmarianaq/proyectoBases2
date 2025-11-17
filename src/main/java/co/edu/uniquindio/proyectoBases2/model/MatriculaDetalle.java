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
public class MatriculaDetalle {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_matricula_detalle")
    private Integer idMatriculaDetalle;

    @Column(name = "id_matricula")
    private Integer idMatricula;

    @Column(name = "id_grupo")
    private Integer idGrupo;

    @Column(name = "estado_inscripcion")
    private String estadoInscripcion;

    @Column(name = "intento_numero")
    private Integer intentoNumero;

    @Builder
    public MatriculaDetalle(Integer idMatriculaDetalle, Integer idMatricula, Integer idGrupo, String estadoInscripcion,
                            Integer intentoNumero) {
        this.idMatriculaDetalle = idMatriculaDetalle;
        this.idMatricula = idMatricula;
        this.idGrupo = idGrupo;
        this.estadoInscripcion = estadoInscripcion;
        this.intentoNumero = intentoNumero;
    }
}
