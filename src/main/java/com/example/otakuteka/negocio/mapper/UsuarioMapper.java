package com.example.otakuteka.negocio.mapper;

import com.example.otakuteka.entidad.Usuarios;
import com.example.otakuteka.negocio.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(source = "nombre", target="nombre")
    @Mapping(target = "contrasenia", ignore = true)
    UsuarioDTO entityToDTO(Usuarios usuario);

    @Mapping(source = "nombre", target="nombre")
    Usuarios dtoToEntity(UsuarioDTO usuario);
}
