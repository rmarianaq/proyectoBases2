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
public class EvaluacionEspecial {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_evaluacion_especial;

    private Integer id_matricula_detalle;
    private Integer id_tipo_evaluacion;
    private LocalDateTime fecha_examen;
    private Double costo;
    private String pagado;
    private LocalDateTime fecha_pago;
    private Double nota_obtenida;
    private LocalDateTime fecha_registro_nota;
    private String observaciones;

    @Builder
    public EvaluacionEspecial(Integer id_evaluacion_especial, Integer id_matricula_detalle, Integer id_tipo_evaluacion, LocalDateTime fecha_examen, Double costo, String pagado, LocalDateTime fecha_pago, Double nota_obtenida, LocalDateTime fecha_registro_nota, String observaciones) {
        this.id_evaluacion_especial = id_evaluacion_especial;
        this.id_matricula_detalle = id_matricula_detalle;
        this.id_tipo_evaluacion = id_tipo_evaluacion;
        this.fecha_examen = fecha_examen;
        this.costo = costo;
        this.pagado = pagado;
        this.fecha_pago = fecha_pago;
        this.nota_obtenida = nota_obtenida;
        this.fecha_registro_nota = fecha_registro_nota;
        this.observaciones = observaciones;
    }
}
