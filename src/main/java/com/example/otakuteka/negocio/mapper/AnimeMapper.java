package com.example.otakuteka.negocio.mapper;

import com.example.otakuteka.entidad.Anime;
import com.example.otakuteka.negocio.dto.AnimeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnimeMapper {

    @Mapping(source = "nombreAnime", target="nombreAnime")
    @Mapping(target = "promedioPuntaje", ignore = true)
    AnimeDTO entityToDTO(Anime anime);

    @Mapping(source = "nombreAnime", target="nombreAnime")
    Anime dtoToEntity(AnimeDTO anime);

}
