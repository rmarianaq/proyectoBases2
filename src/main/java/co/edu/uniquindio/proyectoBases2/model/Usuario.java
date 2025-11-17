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
public class Usuario {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "username")
    private String username;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "tipo_usuario")
    private String tipoUsuario;

    @Column(name = "id_estudiante")
    private Integer idEstudiante;

    @Column(name = "id_profesor")
    private Integer idProfesor;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "ultimo_acceso")
    private LocalDateTime ultimoAcceso;

    @Column(name = "activo")
    private String activo;

    @Builder
    public Usuario(Integer idUsuario, String username, String passwordHash, String tipoUsuario,
                   Integer idEstudiante, Integer idProfesor, LocalDateTime fechaCreacion,
                   LocalDateTime ultimoAcceso, String activo) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.passwordHash = passwordHash;
        this.tipoUsuario = tipoUsuario;
        this.idEstudiante = idEstudiante;
        this.idProfesor = idProfesor;
        this.fechaCreacion = fechaCreacion;
        this.ultimoAcceso = ultimoAcceso;
        this.activo = activo;
    }
}
