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
public class ProfesorGrupo {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_profesor")
    private Integer idProfesor;

    @EqualsAndHashCode.Include
    @Column(name = "id_grupo")
    private Integer idGrupo;

    @Column(name = "tipo_participacion")
    private String tipoParticipacion;

    @Column(name = "horas_asignadas")
    private Integer horasAsignadas;

    @Builder
    public ProfesorGrupo(Integer idProfesor, Integer idGrupo, String tipoParticipacion, Integer horasAsignadas) {
        this.idProfesor = idProfesor;
        this.idGrupo = idGrupo;
        this.tipoParticipacion = tipoParticipacion;
        this.horasAsignadas = horasAsignadas;
    }
}
