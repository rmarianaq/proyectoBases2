package co.edu.uniquindio.proyectoBases2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comentarios")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Comentario {

    @Id
    @EqualsAndHashCode.Include
    private String idComentario;

    private String idPeriodo;
    private String idAsignatura;
    private String comentario;

    @Builder
    public Comentario(String idComentario, String idPeriodo, String idAsignatura, String comentario) {
        this.idComentario = idComentario;
        this.idPeriodo = idPeriodo;
        this.idAsignatura = idAsignatura;
        this.comentario = comentario;
    }
}

