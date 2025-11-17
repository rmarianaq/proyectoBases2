package co.edu.uniquindio.proyectoBases2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class CancelacionAsignatura {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_cancelacion")
    private Integer idCancelacion;

    @Column(name = "id_matricula_detalle")
    private Integer idMatriculaDetalle;

    @Column(name = "fecha_cancelacion")
    private LocalDateTime fechaCancelacion;

    @Column(name = "motivo")
    private String motivo;

    @Builder
    public CancelacionAsignatura(Integer idCancelacion, Integer idMatriculaDetalle,
                                 LocalDateTime fechaCancelacion, String motivo) {
        this.idCancelacion = idCancelacion;
        this.idMatriculaDetalle = idMatriculaDetalle;
        this.fechaCancelacion = fechaCancelacion;
        this.motivo = motivo;
    }
}
