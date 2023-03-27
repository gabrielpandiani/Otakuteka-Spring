package com.example.otakuteka.datos;

import com.example.otakuteka.entidad.Anime;
import com.example.otakuteka.entidad.AnimeHasUsuarios;
import com.example.otakuteka.entidad.Usuarios;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DatosDummy {
    public static Usuarios getUser(){
        List<AnimeHasUsuarios> listaDummy = new ArrayList<>();
        return new Usuarios(1,"admin", "1234","admin@gmail.com", listaDummy);
    }

    public static Anime getAnime(){
        List<AnimeHasUsuarios> listaDummy = new ArrayList<>();
        return new Anime(1,"test","comedia","sinopTest","Invierno 2023","test.jpg",listaDummy);

    }

    public static Optional<AnimeHasUsuarios> getRelacion(){
        List<AnimeHasUsuarios> listaDummy = new ArrayList<>();
        Anime animeRe = new Anime(1,"test","comedia","sinopTest","Invierno 2023","test.jpg",listaDummy);
        Usuarios usuarioRe = new Usuarios(1,"admin", "1234","admin@gmail.com", listaDummy);
        return Optional.of(new AnimeHasUsuarios(1, usuarioRe, animeRe, 4));
    }
}
