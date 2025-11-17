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
public class Programa {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_programa")
    private Integer idPrograma;

    @Column(name = "codigo_programa")
    private String codigoPrograma;

    @Column(name = "nombre_programa")
    private String nombrePrograma;

    @Column(name = "creditos_totales")
    private Integer creditosTotales;

    @Column(name = "id_tipo_programa")
    private Integer idTipoPrograma;

    @Column(name = "id_facultad")
    private Integer idFacultad;

    @Column(name = "duracion_semestres")
    private Integer duracionSemestres;

    @Column(name = "activo")
    private String activo;

    @Builder
    public Programa(Integer idPrograma, String codigoPrograma, String nombrePrograma, Integer creditosTotales,
                    Integer idTipoPrograma, Integer idFacultad, Integer duracionSemestres, String activo) {
        this.idPrograma = idPrograma;
        this.codigoPrograma = codigoPrograma;
        this.nombrePrograma = nombrePrograma;
        this.creditosTotales = creditosTotales;
        this.idTipoPrograma = idTipoPrograma;
        this.idFacultad = idFacultad;
        this.duracionSemestres = duracionSemestres;
        this.activo = activo;
    }
}
