package co.edu.uniquindio.proyectoBases2.services.impl;

import co.edu.uniquindio.proyectoBases2.exceptions.BusinessException;
import co.edu.uniquindio.proyectoBases2.model.Grupo;
import co.edu.uniquindio.proyectoBases2.model.HorarioGrupo;
import co.edu.uniquindio.proyectoBases2.model.Salon;
import co.edu.uniquindio.proyectoBases2.repositories.GrupoRepository;
import co.edu.uniquindio.proyectoBases2.repositories.HorarioGrupoRepository;
import co.edu.uniquindio.proyectoBases2.repositories.MatriculaDetalleRepository;
import co.edu.uniquindio.proyectoBases2.repositories.SalonRepository;
import co.edu.uniquindio.proyectoBases2.services.GrupoService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class GrupoServiceImpl implements GrupoService {

    private final GrupoRepository repo;
    private final HorarioGrupoRepository horarioRepo;
    private final MatriculaDetalleRepository detalleRepo;

    public GrupoServiceImpl(GrupoRepository repo, HorarioGrupoRepository horarioRepo, MatriculaDetalleRepository detalleRepo) {
        this.repo = repo;
        this.horarioRepo = horarioRepo;
        this.detalleRepo = detalleRepo;
    }

    public Grupo obtener(Integer id){return repo.findById(id).orElseThrow();}
    public List<Grupo> listar(){return repo.findAll();}
    public Grupo crear(Grupo g){return repo.save(g);}

    public boolean tieneCupo(Integer idGrupo){
        Grupo g = obtener(idGrupo);
        return g.getCupo_ocupado() < g.getCupo_maximo();
    }

    public boolean hayChoque(Integer g1, Integer g2){
        var h1 = horarioRepo.obtenerHorario(g1);
        var h2 = horarioRepo.obtenerHorario(g2);

        // choque simplificado
        for(var a: h1){
            for(var b: h2){
                if(a.getDia_semana().equals(b.getDia_semana())){
                    if(a.getHora_inicio().equals(b.getHora_inicio())){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

