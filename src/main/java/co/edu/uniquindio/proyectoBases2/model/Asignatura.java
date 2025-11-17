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
public class Asignatura {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_asignatura;

    private String codigo_asignatura;
    private String nombre_asignatura;
    private Integer creditos;
    private Integer horas_semanales;

    private Integer id_tipo_asignatura;
    private Integer id_programa;
    private Integer semestre_sugerido;
    private String obligatoria;
    private String descripcion;
    private String activa;

    @Builder
    public Asignatura(Integer id_asignatura, String codigo_asignatura, String nombre_asignatura, Integer creditos, Integer horas_semanales, Integer id_tipo_asignatura, Integer id_programa, Integer semestre_sugerido, String obligatoria, String descripcion, String activa) {
        this.id_asignatura = id_asignatura;
        this.codigo_asignatura = codigo_asignatura;
        this.nombre_asignatura = nombre_asignatura;
        this.creditos = creditos;
        this.horas_semanales = horas_semanales;
        this.id_tipo_asignatura = id_tipo_asignatura;
        this.id_programa = id_programa;
        this.semestre_sugerido = semestre_sugerido;
        this.obligatoria = obligatoria;
        this.descripcion = descripcion;
        this.activa = activa;
    }
}
