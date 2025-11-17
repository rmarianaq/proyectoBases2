package co.edu.uniquindio.proyectoBases2.model;

import jakarta.persistence.Column;
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
    @Column(name = "id_requisito_especial")
    private Integer idRequisitoEspecial;

    @Column(name = "id_asignatura")
    private Integer idAsignatura;

    @Column(name = "id_tipo_requisito")
    private Integer idTipoRequisito;

    @Column(name = "porcentaje_creditos_minimo")
    private Double porcentajeCreditosMinimo;

    @Column(name = "descripcion")
    private String descripcion;

    @Builder
    public RequisitoEspecialAsignatura(Integer idRequisitoEspecial, Integer idAsignatura, Integer idTipoRequisito,
                                       Double porcentajeCreditosMinimo, String descripcion) {
        this.idRequisitoEspecial = idRequisitoEspecial;
        this.idAsignatura = idAsignatura;
        this.idTipoRequisito = idTipoRequisito;
        this.porcentajeCreditosMinimo = porcentajeCreditosMinimo;
        this.descripcion = descripcion;
    }
}
