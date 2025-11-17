package co.edu.uniquindio.proyectoBases2.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Prerrequisito {

    @Id
    private Integer id_asignatura;

    private Integer  id_asignatura_prerequisito;

    @Builder
    public Prerrequisito(Integer id_asignatura, Integer id_asignatura_prerequisito) {
        this.id_asignatura = id_asignatura;
        this.id_asignatura_prerequisito = id_asignatura_prerequisito;
    }
}
