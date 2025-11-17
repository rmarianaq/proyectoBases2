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
public class NivelEducativo {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_nivel_educativo")
    private Integer idNivelEducativo;

    @Column(name = "codigo_nivel")
    private String codigoNivel;

    @Column(name = "nombre_nivel")
    private String nombreNivel;

    @Column(name = "orden_nivel")
    private Integer ordenNivel;

    @Builder
    public NivelEducativo(Integer idNivelEducativo, String codigoNivel, String nombreNivel, Integer ordenNivel) {
        this.idNivelEducativo = idNivelEducativo;
        this.codigoNivel = codigoNivel;
        this.nombreNivel = nombreNivel;
        this.ordenNivel = ordenNivel;
    }
}

