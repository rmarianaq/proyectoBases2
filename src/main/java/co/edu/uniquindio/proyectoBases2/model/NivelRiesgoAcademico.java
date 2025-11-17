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
public class NivelRiesgoAcademico {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_nivel_riesgo;
    private Integer nivel_riesgo;
    private String nombre_nivel;
    private String descripcion;
    private Integer creditos_maximos;

    @Builder
    public NivelRiesgoAcademico(Integer id_nivel_riesgo, Integer nivel_riesgo, String nombre_nivel, String descripcion, Integer creditos_maximos) {
        this.id_nivel_riesgo = id_nivel_riesgo;
        this.nivel_riesgo = nivel_riesgo;
        this.nombre_nivel = nombre_nivel;
        this.descripcion = descripcion;
        this.creditos_maximos = creditos_maximos;
    }
}
