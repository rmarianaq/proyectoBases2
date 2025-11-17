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
public class TituloUniversitario {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_titulo;

    private Integer id_profesor;
    private Integer id_nivel_educativo;
    private String institucion;
    private String titulo_obtenido;
    private LocalDateTime fecha_obtencion;
    private String pais;

    @Builder
    public TituloUniversitario(Integer id_titulo, Integer id_profesor, Integer id_nivel_educativo, String institucion, String titulo_obtenido, LocalDateTime fecha_obtencion, String pais) {
        this.id_titulo = id_titulo;
        this.id_profesor = id_profesor;
        this.id_nivel_educativo = id_nivel_educativo;
        this.institucion = institucion;
        this.titulo_obtenido = titulo_obtenido;
        this.fecha_obtencion = fecha_obtencion;
        this.pais = pais;
    }
}
