package com.example.otakuteka.controlador;


import com.example.otakuteka.entidad.Anime;
import com.example.otakuteka.negocio.dto.AnimeDTO;
import com.example.otakuteka.repositorio.AnimeRepo;
import com.example.otakuteka.servicio.AnimeServi;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/anime")
public class AnimeControlador {
    private final AnimeRepo repo;
    private final AnimeServi servi;
    public AnimeControlador(AnimeRepo repo, AnimeServi servi){
        this.repo = repo;
        this.servi = servi;
    }
    @GetMapping("/todos")
    public List<AnimeDTO> find(){
        return servi.find();
    }

    @GetMapping("/todos/{idAnime}")
    public AnimeDTO find(@PathVariable("idAnime")Integer idAnime){

        return servi.find(idAnime);
    }



}
