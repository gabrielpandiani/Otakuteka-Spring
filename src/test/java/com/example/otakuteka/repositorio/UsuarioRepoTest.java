package com.example.otakuteka.repositorio;

import com.example.otakuteka.datos.DatosDummy;
import com.example.otakuteka.entidad.Usuarios;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UsuarioRepoTest {

    @Autowired
    private UsuarioRepo urepo;

    @BeforeEach
    void setUp() {
        urepo.save(DatosDummy.getUser());
    }

    @AfterEach
    void tearDown() {
        urepo.deleteAll();
    }

    @Test
    void findByNombre() {
        Optional<Usuarios> usuarioOpcional = this.urepo.findByNombre("admin");

        assertThat(usuarioOpcional.isPresent()).isTrue();
        assertThat(usuarioOpcional.get().getNombre()).isEqualTo("admin");
    }

    @Test
    void findByNombreAndContrasenia() {
        Optional<Usuarios> usuarioOpcional = this.urepo.findByNombreAndContrasenia("admin","1234");

        assertThat(usuarioOpcional.isPresent()).isTrue();
        assertThat(usuarioOpcional.get().getNombre()).isEqualTo("admin");
        assertThat(usuarioOpcional.get().getContrasenia()).isEqualTo("1234");
     }
    }
