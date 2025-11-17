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
public class NotaDefinitiva {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_nota_definitiva;

    private Integer id_asignatura;
    private Integer id_matricula_detalle;
    private Double nota_definitiva;
    private String aprobada;
    private LocalDateTime fecha_calculo;
    private String consolidada;

    @Builder
    public NotaDefinitiva(Integer id_nota_definitiva, Integer id_asignatura, Integer id_matricula_detalle, Double nota_definitiva, String aprobada, LocalDateTime fecha_calculo, String consolidada) {
        this.id_nota_definitiva = id_nota_definitiva;
        this.id_asignatura = id_asignatura;
        this.id_matricula_detalle = id_matricula_detalle;
        this.nota_definitiva = nota_definitiva;
        this.aprobada = aprobada;
        this.fecha_calculo = fecha_calculo;
        this.consolidada = consolidada;
    }
}
