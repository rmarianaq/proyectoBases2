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
public class ProfesorGrupo {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_profesor;
    @EqualsAndHashCode.Include
    private Integer id_grupo;
    private String tipo_participacion;
    private Integer horas_asignadas;

    @Builder
    public ProfesorGrupo(Integer id_profesor, Integer id_grupo, String tipo_participacion, Integer horas_asignadas) {
        this.id_profesor = id_profesor;
        this.id_grupo = id_grupo;
        this.tipo_participacion = tipo_participacion;
        this.horas_asignadas = horas_asignadas;
    }
}
