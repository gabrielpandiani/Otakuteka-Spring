package com.example.otakuteka.servicio;

import com.example.otakuteka.datos.DatosDummy;
import com.example.otakuteka.entidad.Usuarios;
import com.example.otakuteka.repositorio.UsuarioRepo;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@SpringBootTest
class UsuarioServiImplTest {

    @MockBean
    private UsuarioRepo uRepo;
    @Autowired
    private UsuarioServi uServi;

    @Test
    void findById() {
        Integer idusuarios = 1;

        when(uRepo.findById(idusuarios)).thenReturn(Optional.of(DatosDummy.getUser()));
        Usuarios usuario = uServi.findById(idusuarios).get();

        assertThat(usuario.getIdusuarios()).isEqualTo(1);
    }


    @Test
    void validarUsuario() {
        Usuarios usuario = DatosDummy.getUser();
        given(uRepo.findByNombreAndContrasenia(usuario.getNombre(), usuario.getContrasenia())).willReturn(Optional.of(usuario));
        Boolean usuarioT = uServi.validarUsuario(usuario);

        assertThat(usuarioT).isTrue();
    }

    @Test
    void add() {
        Usuarios usuario = DatosDummy.getUser();
        uServi.add(usuario);

        ArgumentCaptor<Usuarios> usuarioCapturador = ArgumentCaptor.forClass(Usuarios.class);
        verify(uRepo).save(usuarioCapturador.capture());

        Usuarios userCaptor = usuarioCapturador.getValue();

        assertThat(userCaptor).isEqualTo(usuario);

        verify(uRepo).save(any());
    }

    @Test
    void delete() {
        Integer idusuarios = 1;

        given(uRepo.findById(idusuarios)).willReturn(Optional.of(DatosDummy.getUser()));
        willDoNothing().given(uRepo).deleteById(idusuarios);

        uServi.delete(idusuarios);

        verify(uRepo,times(1)).deleteById(any());
    }
}