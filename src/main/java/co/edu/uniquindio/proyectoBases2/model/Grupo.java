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
public class Grupo {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_grupo")
    private Integer idGrupo;

    @Column(name = "id_asignatura")
    private Integer idAsignatura;

    @Column(name = "id_periodo")
    private Integer idPeriodo;

    @Column(name = "numero_grupo")
    private String numeroGrupo;

    @Column(name = "cupo_maximo")
    private Integer cupoMaximo;

    @Column(name = "cupo_ocupado")
    private Integer cupoOcupado;

    @Column(name = "activo")
    private String activo;

    @Builder
    public Grupo(Integer idGrupo, Integer idAsignatura, Integer idPeriodo,
                 String numeroGrupo, Integer cupoMaximo, Integer cupoOcupado, String activo) {
        this.idGrupo = idGrupo;
        this.idAsignatura = idAsignatura;
        this.idPeriodo = idPeriodo;
        this.numeroGrupo = numeroGrupo;
        this.cupoMaximo = cupoMaximo;
        this.cupoOcupado = cupoOcupado;
        this.activo = activo;
    }
}
