package co.edu.uniquindio.proyectoBases2.model;

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
    private Integer id_cancelacion;

    private Integer id_matricula_detalle;

    private LocalDateTime fecha_cancelacion;
    private String motivo;

    @Builder
    public CancelacionAsignatura(Integer id_cancelacion, Integer id_matricula_detalle, LocalDateTime fecha_cancelacion, String motivo) {
        this.id_cancelacion = id_cancelacion;
        this.id_matricula_detalle = id_matricula_detalle;
        this.fecha_cancelacion = fecha_cancelacion;
        this.motivo = motivo;
    }
}
