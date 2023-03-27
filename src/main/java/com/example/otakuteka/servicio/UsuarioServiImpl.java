package com.example.otakuteka.servicio;

import com.example.otakuteka.entidad.Usuarios;
import com.example.otakuteka.repositorio.UsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiImpl implements UsuarioServi{
    private final UsuarioRepo repo;

    public UsuarioServiImpl(UsuarioRepo repo){
        this.repo = repo;
    }

    @Override
    public Optional<Usuarios> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public boolean validarUsuario(Usuarios valor){
            return repo.findByNombreAndContrasenia(valor.getNombre(), valor.getContrasenia()).isPresent();
    }

    @Override
    public Usuarios add(Usuarios valor) {
        return repo.save(valor);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
