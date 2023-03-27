package com.example.otakuteka.servicio;

import com.example.otakuteka.entidad.Usuarios;

import java.util.Optional;

public interface UsuarioServi {


    public Optional<Usuarios> findById(Integer id);

    public boolean validarUsuario(Usuarios valor);
    public Usuarios add(Usuarios valor);

    public void delete(Integer id);
}
