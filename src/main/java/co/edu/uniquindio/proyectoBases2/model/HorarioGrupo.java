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
public class HorarioGrupo {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_horario")
    private Integer idHorario;

    @Column(name = "id_grupo")
    private Integer idGrupo;

    @Column(name = "id_salon")
    private Integer idSalon;

    @Column(name = "dia_semana")
    private String diaSemana;

    @Column(name = "hora_inicio")
    private String horaInicio;

    @Column(name = "hora_fin")
    private String horaFin;

    @Builder
    public HorarioGrupo(Integer idHorario, Integer idGrupo, Integer idSalon,
                        String diaSemana, String horaInicio, String horaFin) {
        this.idHorario = idHorario;
        this.idGrupo = idGrupo;
        this.idSalon = idSalon;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
}
