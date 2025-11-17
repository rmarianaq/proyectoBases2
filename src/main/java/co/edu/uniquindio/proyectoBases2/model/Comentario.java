package co.edu.uniquindio.proyectoBases2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Document(collection = "comentarios")
public class Comentario {

    @Id
    @EqualsAndHashCode.Include
    private String id_comentario;
    private String id_periodo;
    private String id_asignatura;
    private String comentario;

    @Builder
    public Comentario(String id_comentario, String id_periodo, String id_asignatura, String comentario) {
        this.id_comentario = id_comentario;
        this.id_periodo = id_periodo;
        this.id_asignatura = id_asignatura;
        this.comentario = comentario;
    }
}
