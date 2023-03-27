package com.example.otakuteka.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="anime")

public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anime")
    private Integer idAnime;

    @Column(name = "nombre_anime")
    private String nombreAnime;

    @Column(name = "genero")
    private String genero;

    @Column(name = "sinopsis")
    @Lob
    private String sinopsis;

    @Column(name = "temporada_emision")
    private String temporada_emision;

    @Column(name = "imagen")
    private String imagen;

    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<AnimeHasUsuarios> cantidadPuntaje;


}
