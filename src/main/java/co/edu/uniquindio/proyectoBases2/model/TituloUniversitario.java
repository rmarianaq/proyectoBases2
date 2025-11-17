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
public class TituloUniversitario {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_titulo")
    private Integer idTitulo;

    @Column(name = "id_profesor")
    private Integer idProfesor;

    @Column(name = "id_nivel_educativo")
    private Integer idNivelEducativo;

    @Column(name = "institucion")
    private String institucion;

    @Column(name = "titulo_obtenido")
    private String tituloObtenido;

    @Column(name = "fecha_obtencion")
    private LocalDateTime fechaObtencion;

    @Column(name = "pais")
    private String pais;

    @Builder
    public TituloUniversitario(Integer idTitulo, Integer idProfesor, Integer idNivelEducativo, String institucion,
                               String tituloObtenido, LocalDateTime fechaObtencion, String pais) {
        this.idTitulo = idTitulo;
        this.idProfesor = idProfesor;
        this.idNivelEducativo = idNivelEducativo;
        this.institucion = institucion;
        this.tituloObtenido = tituloObtenido;
        this.fechaObtencion = fechaObtencion;
        this.pais = pais;
    }
}

