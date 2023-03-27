package com.example.otakuteka.servicio;

import com.example.otakuteka.entidad.Anime;
import com.example.otakuteka.negocio.dto.AnimeDTO;


import java.util.List;
import java.util.Optional;

public interface AnimeServi {

    public List<AnimeDTO> find();

    public AnimeDTO find(Integer id);

    public Optional<Anime> findByNombre(String nombre);
}
