package com.example.otakuteka.negocio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimeDTO {
    private Integer idAnime;

    private String nombreAnime;

    private String genero;

    private double promedioPuntaje;

    private String sinopsis;

    private String temporada_emision;

    private String imagen;
}
