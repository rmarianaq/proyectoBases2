package co.edu.uniquindio.proyectoBases2.model;

import jakarta.persistence.Column;
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
    @Column(name = "id_asignatura")
    private Integer idAsignatura;

    @Column(name = "id_asignatura_prerequisito")
    private Integer idAsignaturaPrerequisito;

    @Builder
    public Prerrequisito(Integer idAsignatura, Integer idAsignaturaPrerequisito) {
        this.idAsignatura = idAsignatura;
        this.idAsignaturaPrerequisito = idAsignaturaPrerequisito;
    }
}
