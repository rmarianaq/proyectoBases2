package co.edu.uniquindio.proyectoBases2.model;

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
    private Integer id_matricula_detalle;
    private Integer id_matricula;
    private Integer id_grupo;
    private String estado_inscripcion;
    private Integer intento_numero;

    @Builder
    public MatriculaDetalle(Integer id_matricula_detalle, Integer id_matricula, Integer id_grupo, String estado_inscripcion, Integer intento_numero) {
        this.id_matricula_detalle = id_matricula_detalle;
        this.id_matricula = id_matricula;
        this.id_grupo = id_grupo;
        this.estado_inscripcion = estado_inscripcion;
        this.intento_numero = intento_numero;
    }
}
