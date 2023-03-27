package com.example.otakuteka.servicio;

import com.example.otakuteka.entidad.Anime;
import com.example.otakuteka.entidad.AnimeHasUsuarios;
import com.example.otakuteka.entidad.Usuarios;
import com.example.otakuteka.repositorio.AnimeHasUsuariosRepo;
import com.example.otakuteka.repositorio.AnimeRepo;
import com.example.otakuteka.repositorio.UsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnimeHasUsuariosServiImpl implements AnimeHasUsuariosServi{
    private final AnimeHasUsuariosRepo repo;
    private final UsuarioRepo uRepo;
    private final AnimeRepo aRepo;

    public AnimeHasUsuariosServiImpl(AnimeHasUsuariosRepo repo, UsuarioRepo uRepo, AnimeRepo aRepo){
        this.repo = repo;
        this.uRepo = uRepo;
        this.aRepo = aRepo;
    }


    @Override
    public Optional<AnimeHasUsuarios> find(Integer id) {
        return repo.findById(id);
    }

    public boolean noEstaRepetido(AnimeHasUsuarios valor){
        Optional<Usuarios> usuarioBuscado = this.uRepo.findByNombre(valor.getUsuario().getNombre());
        Optional<Anime> animeBuscado = this.aRepo.findById(valor.getAnime().getIdAnime());

        return repo.buscarRelacion(usuarioBuscado.get().getIdusuarios(),animeBuscado.get().getIdAnime()).isEmpty();
    }

    @Override
    public AnimeHasUsuarios add(AnimeHasUsuarios valor) {
        Optional<Usuarios> usuarioBuscado = this.uRepo.findByNombre(valor.getUsuario().getNombre());
        Optional<Anime> animeBuscado = this.aRepo.findById(valor.getAnime().getIdAnime());
        AnimeHasUsuarios puntajeNuevo = new AnimeHasUsuarios();
        if (!noEstaRepetido(valor)){
            throw new RuntimeException();
        }
        puntajeNuevo.setUsuario(usuarioBuscado.get());
        puntajeNuevo.setAnime(animeBuscado.get());
        puntajeNuevo.setPuntaje(valor.getPuntaje());
        return repo.save(puntajeNuevo);
    }

}
