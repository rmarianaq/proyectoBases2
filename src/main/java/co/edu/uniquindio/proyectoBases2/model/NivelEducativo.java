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
public class NivelEducativo {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_nivel_educativo;
    private String codigo_nivel;
    private String nombre_nivel;
    private Integer orden_nivel;

    @Builder
    public NivelEducativo(Integer id_nivel_educativo, String codigo_nivel, String nombre_nivel, Integer orden_nivel) {
        this.id_nivel_educativo = id_nivel_educativo;
        this.codigo_nivel = codigo_nivel;
        this.nombre_nivel = nombre_nivel;
        this.orden_nivel = orden_nivel;
    }
}
