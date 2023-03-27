package com.example.otakuteka.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="anime_has_usuarios")
public class AnimeHasUsuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anime_usuarios")
    private Integer idAnimeUsuarios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarios_idusuarios")
    private Usuarios usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anime_id_anime")
    private Anime anime;

    @Column(name = "puntaje")
    private Integer puntaje;

}
