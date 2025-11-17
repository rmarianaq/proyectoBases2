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
public class Asignatura {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_asignatura")
    private Integer idAsignatura;

    @Column(name = "codigo_asignatura")
    private String codigoAsignatura;

    @Column(name = "nombre_asignatura")
    private String nombreAsignatura;

    @Column(name = "creditos")
    private Integer creditos;

    @Column(name = "horas_semanales")
    private Integer horasSemanales;

    @Column(name = "id_tipo_asignatura")
    private Integer idTipoAsignatura;

    @Column(name = "id_programa")
    private Integer idPrograma;

    @Column(name = "semestre_sugerido")
    private Integer semestreSugerido;

    @Column(name = "obligatoria")
    private String obligatoria;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "activa")
    private String activa;

    @Builder
    public Asignatura(Integer idAsignatura, String codigoAsignatura, String nombreAsignatura,
                      Integer creditos, Integer horasSemanales, Integer idTipoAsignatura,
                      Integer idPrograma, Integer semestreSugerido, String obligatoria,
                      String descripcion, String activa) {
        this.idAsignatura = idAsignatura;
        this.codigoAsignatura = codigoAsignatura;
        this.nombreAsignatura = nombreAsignatura;
        this.creditos = creditos;
        this.horasSemanales = horasSemanales;
        this.idTipoAsignatura = idTipoAsignatura;
        this.idPrograma = idPrograma;
        this.semestreSugerido = semestreSugerido;
        this.obligatoria = obligatoria;
        this.descripcion = descripcion;
        this.activa = activa;
    }
}
