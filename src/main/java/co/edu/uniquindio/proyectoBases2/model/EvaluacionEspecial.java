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
public class EvaluacionEspecial {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_evaluacion_especial")
    private Integer idEvaluacionEspecial;

    @Column(name = "id_matricula_detalle")
    private Integer idMatriculaDetalle;

    @Column(name = "id_tipo_evaluacion")
    private Integer idTipoEvaluacion;

    @Column(name = "fecha_examen")
    private LocalDateTime fechaExamen;

    @Column(name = "costo")
    private Double costo;

    @Column(name = "pagado")
    private String pagado;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    @Column(name = "nota_obtenida")
    private Double notaObtenida;

    @Column(name = "fecha_registro_nota")
    private LocalDateTime fechaRegistroNota;

    @Column(name = "observaciones")
    private String observaciones;

    @Builder
    public EvaluacionEspecial(Integer idEvaluacionEspecial, Integer idMatriculaDetalle, Integer idTipoEvaluacion,
                              LocalDateTime fechaExamen, Double costo, String pagado, LocalDateTime fechaPago,
                              Double notaObtenida, LocalDateTime fechaRegistroNota, String observaciones) {

        this.idEvaluacionEspecial = idEvaluacionEspecial;
        this.idMatriculaDetalle = idMatriculaDetalle;
        this.idTipoEvaluacion = idTipoEvaluacion;
        this.fechaExamen = fechaExamen;
        this.costo = costo;
        this.pagado = pagado;
        this.fechaPago = fechaPago;
        this.notaObtenida = notaObtenida;
        this.fechaRegistroNota = fechaRegistroNota;
        this.observaciones = observaciones;
    }
}
