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
public class NotaDefinitiva {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_nota_definitiva")
    private Integer idNotaDefinitiva;

    @Column(name = "id_asignatura")
    private Integer idAsignatura;

    @Column(name = "id_matricula_detalle")
    private Integer idMatriculaDetalle;

    @Column(name = "nota_definitiva")
    private Double notaDefinitiva;

    @Column(name = "aprobada")
    private String aprobada;

    @Column(name = "fecha_calculo")
    private LocalDateTime fechaCalculo;

    @Column(name = "consolidada")
    private String consolidada;

    @Builder
    public NotaDefinitiva(Integer idNotaDefinitiva, Integer idAsignatura, Integer idMatriculaDetalle,
                          Double notaDefinitiva, String aprobada, LocalDateTime fechaCalculo,
                          String consolidada) {
        this.idNotaDefinitiva = idNotaDefinitiva;
        this.idAsignatura = idAsignatura;
        this.idMatriculaDetalle = idMatriculaDetalle;
        this.notaDefinitiva = notaDefinitiva;
        this.aprobada = aprobada;
        this.fechaCalculo = fechaCalculo;
        this.consolidada = consolidada;
    }
}
