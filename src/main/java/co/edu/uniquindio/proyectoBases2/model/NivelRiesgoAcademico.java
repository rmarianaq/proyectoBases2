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
public class NivelRiesgoAcademico {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_nivel_riesgo")
    private Integer idNivelRiesgo;

    @Column(name = "nivel_riesgo")
    private Integer nivelRiesgo;

    @Column(name = "nombre_nivel")
    private String nombreNivel;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "creditos_maximos")
    private Integer creditosMaximos;

    @Builder
    public NivelRiesgoAcademico(Integer idNivelRiesgo, Integer nivelRiesgo, String nombreNivel,
                                String descripcion, Integer creditosMaximos) {
        this.idNivelRiesgo = idNivelRiesgo;
        this.nivelRiesgo = nivelRiesgo;
        this.nombreNivel = nombreNivel;
        this.descripcion = descripcion;
        this.creditosMaximos = creditosMaximos;
    }
}

