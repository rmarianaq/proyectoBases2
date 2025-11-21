package co.edu.uniquindio.proyectoBases2.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Integer idComentario;

    @Column(name = "id_matricula_detalle")
    private Integer idMatriculaDetalle;

    @Column(name = "id_comentario_nosql")
    private String idComentarioNosql;

    @Column(name = "migrado_nosql")
    private String migradoNosql;

    @Column(name = "anonimo")
    private String anonimo;

    @Builder
    public Comentario(Integer idComentario, Integer idMatriculaDetalle, String idComentarioNosql, String migradoNosql, String anonimo) {
        this.idComentario = idComentario;
        this.idMatriculaDetalle = idMatriculaDetalle;
        this.idComentarioNosql = idComentarioNosql;
        this.migradoNosql = migradoNosql;
        this.anonimo = anonimo;
    }
}
