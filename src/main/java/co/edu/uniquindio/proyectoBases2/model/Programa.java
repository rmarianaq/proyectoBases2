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
public class Programa {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_programa;
    private String codigo_programa;
    private String nombre_programa;
    private Integer creditos_totales;

    private Integer id_tipo_programa;
    private Integer id_facultad;
    private Integer duracion_semestres;
    private String activo;

    @Builder
    public Programa(Integer id_programa, String codigo_programa, String nombre_programa, Integer creditos_totales, Integer id_tipo_programa, Integer id_facultad, Integer duracion_semestres, String activo) {
        this.id_programa = id_programa;
        this.codigo_programa = codigo_programa;
        this.nombre_programa = nombre_programa;
        this.creditos_totales = creditos_totales;
        this.id_tipo_programa = id_tipo_programa;
        this.id_facultad = id_facultad;
        this.duracion_semestres = duracion_semestres;
        this.activo = activo;
    }
}
