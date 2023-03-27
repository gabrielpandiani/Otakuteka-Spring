package com.example.otakuteka.repositorio;

import com.example.otakuteka.entidad.AnimeHasUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimeHasUsuariosRepo extends JpaRepository<AnimeHasUsuarios,Integer> {

    @Query("SELECT au FROM AnimeHasUsuarios au WHERE au.usuario.idusuarios = ?1 AND au.anime.idAnime =?2")
    Optional<AnimeHasUsuarios> buscarRelacion(int idusuario, int anime);

}
