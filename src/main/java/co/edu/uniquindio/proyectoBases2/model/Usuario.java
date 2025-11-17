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
public class Usuario {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_usuario;
    private String username;
    private String password_hash;
    private String tipo_usuario;

    private Integer id_estudiante;
    private Integer id_profesor;
    private LocalDateTime fecha_creacion;
    private LocalDateTime ultimo_acceso;
    private String activo;

    @Builder
    public Usuario(Integer id_usuario, String username, String password_hash, String tipo_usuario, Integer id_estudiante, Integer id_profesor, LocalDateTime fecha_creacion, LocalDateTime ultimo_acceso, String activo) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.password_hash = password_hash;
        this.tipo_usuario = tipo_usuario;
        this.id_estudiante = id_estudiante;
        this.id_profesor = id_profesor;
        this.fecha_creacion = fecha_creacion;
        this.ultimo_acceso = ultimo_acceso;
        this.activo = activo;
    }
}
