package co.edu.uniquindio.proyectoBases2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class RequisitoEspecialAsignatura {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_requisito_especial;

    private Integer id_asignatura;
    private Integer id_tipo_requisito;
    private Double porcentaje_creditos_minimo;
    private String descripcion;

    @Builder
    public RequisitoEspecialAsignatura(Integer id_requisito_especial, Integer id_asignatura, Integer id_tipo_requisito, Double porcentaje_creditos_minimo, String descripcion) {
        this.id_requisito_especial = id_requisito_especial;
        this.id_asignatura = id_asignatura;
        this.id_tipo_requisito = id_tipo_requisito;
        this.porcentaje_creditos_minimo = porcentaje_creditos_minimo;
        this.descripcion = descripcion;
    }
}
