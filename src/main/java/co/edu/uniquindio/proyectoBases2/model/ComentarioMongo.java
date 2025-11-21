package co.edu.uniquindio.proyectoBases2.model;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "comentarios")
@Getter
@Setter
@NoArgsConstructor
@Builder
public class ComentarioMongo {

    @Id
    private String id;

    private Integer idMatriculaDetalle;

    private String texto;

    private Integer calificacionGeneral; // 1 a 5

    private LocalDateTime fechaComentario;

    private List<String> etiquetas;

    private String estado;   // A o I
    @Builder

    public ComentarioMongo(String id, Integer idMatriculaDetalle, String texto, Integer calificacionGeneral, LocalDateTime fechaComentario, List<String> etiquetas, String estado) {
        this.id = id;
        this.idMatriculaDetalle = idMatriculaDetalle;
        this.texto = texto;
        this.calificacionGeneral = calificacionGeneral;
        this.fechaComentario = fechaComentario;
        this.etiquetas = etiquetas;
        this.estado = estado;
    }
}

