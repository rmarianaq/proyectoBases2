package co.edu.uniquindio.proyectoBases2.services.impl;

import co.edu.uniquindio.proyectoBases2.repositories.jpa.AuditoriaRepository;
import co.edu.uniquindio.proyectoBases2.services.AuditoriaService;
import org.springframework.stereotype.Service;

import java.net.InetAddress;

@Service
public class AuditoriaServiceImpl implements AuditoriaService {

    private final AuditoriaRepository auditoriaRepository;

    public AuditoriaServiceImpl(AuditoriaRepository auditoriaRepository) {
        this.auditoriaRepository = auditoriaRepository;
    }

    @Override
    public void registrar(String operacion, String descripcion, String usuario) {

        auditoriaRepository.insertarAuditoria(
                "MATRICULA",     // tabla afectada (puedes cambiarlo si quieres hacerlo dinámico)
                operacion,
                descripcion,
                usuario,
                obtenerIpCliente()
        );
    }

    private String obtenerIpCliente() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            return "0.0.0.0";
        }
    }
}


