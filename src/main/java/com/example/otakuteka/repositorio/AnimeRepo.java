package com.example.otakuteka.repositorio;

import com.example.otakuteka.entidad.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimeRepo extends JpaRepository<Anime,Integer> {

}
