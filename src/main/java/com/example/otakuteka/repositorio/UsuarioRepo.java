package com.example.otakuteka.repositorio;

import com.example.otakuteka.entidad.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UsuarioRepo extends JpaRepository<Usuarios,Integer> {
    public Optional<Usuarios> findByNombre(String nombre);
    public Optional<Usuarios> findByNombreAndContrasenia(String nombre, String contrasenia);

}
