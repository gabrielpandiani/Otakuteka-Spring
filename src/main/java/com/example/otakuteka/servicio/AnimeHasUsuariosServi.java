package com.example.otakuteka.servicio;

import com.example.otakuteka.entidad.AnimeHasUsuarios;


import java.util.Optional;


public interface AnimeHasUsuariosServi {
    public Optional<AnimeHasUsuarios> find(Integer id);

    public AnimeHasUsuarios add(AnimeHasUsuarios valor);

}
