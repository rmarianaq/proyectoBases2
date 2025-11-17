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
public class Grupo {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_grupo;

    private Integer id_asignatura;
    private Integer id_periodo;
    private String numero_grupo;
    private Integer cupo_maximo;
    private Integer cupo_ocupado;
    private String activo;

    @Builder
    public Grupo(Integer id_grupo, Integer id_asignatura, Integer id_periodo, String numero_grupo, Integer cupo_maximo, Integer cupo_ocupado, String activo) {
        this.id_grupo = id_grupo;
        this.id_asignatura = id_asignatura;
        this.id_periodo = id_periodo;
        this.numero_grupo = numero_grupo;
        this.cupo_maximo = cupo_maximo;
        this.cupo_ocupado = cupo_ocupado;
        this.activo = activo;
    }
}
