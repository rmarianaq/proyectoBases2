package co.edu.uniquindio.proyectoBases2.repositories.jpa;

import co.edu.uniquindio.proyectoBases2.model.AuditoriaDummy;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaRepository extends JpaRepository<AuditoriaDummy, Integer> {

    @Modifying
    @Transactional
    @Query(
            value = """
                INSERT INTO auditoria (
                    id_auditoria,
                    tabla_afectada,
                    operacion,
                    id_registro_afectado,
                    usuario,
                    fecha_operacion,
                    valores_anteriores,
                    valores_nuevos,
                    ip_origen
                ) VALUES (
                    auditoria_seq.NEXTVAL,
                    :tabla,
                    :operacion,
                    NULL,
                    :usuario,
                    SYSDATE,
                    :descripcion,
                    NULL,
                    :ip
                )
                """,
            nativeQuery = true
    )
    void insertarAuditoria(
            @Param("tabla") String tabla,
            @Param("operacion") String operacion,
            @Param("descripcion") String descripcion,
            @Param("usuario") String usuario,
            @Param("ip") String ip
    );
}

