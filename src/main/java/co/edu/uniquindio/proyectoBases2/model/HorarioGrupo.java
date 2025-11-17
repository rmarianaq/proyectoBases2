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
public class HorarioGrupo {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_horario;

    private Integer id_grupo;
    private Integer id_salon;
    private String dia_semana;
    private String hora_inicio;
    private String hora_fin;

    @Builder
    public HorarioGrupo(Integer id_horario, Integer id_grupo, Integer id_salon, String dia_semana, String hora_inicio, String hora_fin) {
        this.id_horario = id_horario;
        this.id_grupo = id_grupo;
        this.id_salon = id_salon;
        this.dia_semana = dia_semana;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }
}
