package com.example.otakuteka.servicio;

import com.example.otakuteka.entidad.Anime;
import com.example.otakuteka.entidad.AnimeHasUsuarios;
import com.example.otakuteka.negocio.dto.AnimeDTO;
import com.example.otakuteka.negocio.mapper.AnimeMapper;
import com.example.otakuteka.repositorio.AnimeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimeServiImpl implements AnimeServi {

    private final AnimeRepo repo;
    private final AnimeMapper mapper;

    public AnimeServiImpl(AnimeRepo repo, AnimeMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<AnimeDTO> find() {
        List<Anime> aux = this.repo.findAll();
        List<AnimeDTO> auxDTO = aux.stream()
                .map(mapper::entityToDTO)
                .map(anime -> {
                    anime.setPromedioPuntaje(calcularPromedio(this.repo.findById(anime.getIdAnime()).get()));
                    return anime;
                })
                .collect(Collectors.toList());
        return auxDTO;
    }

    @Override
    public AnimeDTO find(Integer id) {
        Optional<Anime> aux= this.repo.findById(id);
        if (!aux.isPresent()){
            throw new RuntimeException("No existe el anime");
        }
        AnimeDTO auxDTO = mapper.entityToDTO(aux.get());

        auxDTO.setPromedioPuntaje(calcularPromedio(aux.get()));
        return auxDTO;
    }

    @Override
    public Optional<Anime> findByNombre(String nombre) {
        return Optional.empty();
    }

    private static double calcularPromedio(Anime anime) {
        List<AnimeHasUsuarios> puntajes= anime.getCantidadPuntaje();
        double sumaPuntajes=0;
        for (AnimeHasUsuarios puntaje:puntajes) {
            sumaPuntajes += puntaje.getPuntaje();
        }
        double aux = sumaPuntajes/puntajes.size();
        return aux;

    }
}
