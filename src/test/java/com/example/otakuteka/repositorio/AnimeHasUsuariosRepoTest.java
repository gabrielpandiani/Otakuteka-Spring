package com.example.otakuteka.repositorio;

import com.example.otakuteka.datos.DatosDummy;
import com.example.otakuteka.entidad.AnimeHasUsuarios;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class AnimeHasUsuariosRepoTest {
    @Autowired
    private AnimeHasUsuariosRepo repo;
    @Autowired
    private UsuarioRepo uRepo;
    @Autowired
    private AnimeRepo aRepo;

    @BeforeEach
    void setUp() {
        uRepo.save(DatosDummy.getUser());
        aRepo.save(DatosDummy.getAnime());
        repo.save(DatosDummy.getRelacion().get());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void buscarRelacion() {
        Optional<AnimeHasUsuarios> relacionOpcional = this.repo.buscarRelacion(1,1);

        assertThat(relacionOpcional.isPresent()).isTrue();
        assertThat(relacionOpcional.get().getUsuario().getIdusuarios()).isEqualTo(1);
        assertThat(relacionOpcional.get().getAnime().getIdAnime()).isEqualTo(1);
    }
}