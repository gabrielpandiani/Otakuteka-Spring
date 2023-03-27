package com.example.otakuteka.controlador;

import com.example.otakuteka.entidad.AnimeHasUsuarios;
import com.example.otakuteka.servicio.AnimeHasUsuariosServiImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/animehasusuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class AnimeHasUsuarioControlador {

    private final AnimeHasUsuariosServiImpl servi;

    public AnimeHasUsuarioControlador(AnimeHasUsuariosServiImpl servi) {
        this.servi = servi;
    }

    @GetMapping("/{id}")
    public Optional<AnimeHasUsuarios> find(@PathVariable Integer id){
            return servi.find(id);
    }

    @PostMapping("/puntuar")
    public ResponseEntity<?> add(@RequestBody AnimeHasUsuarios valor){
        boolean noRepetido = this.servi.noEstaRepetido(valor);
        if ((valor.getUsuario().getNombre().isBlank())){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Campos obligatorios vacios");
        } else if (!noRepetido) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Ya existe una votacion de este usuario");
        } else{
            return ResponseEntity.status(HttpStatus.CREATED).body(servi.add(valor));
        }
    }


}
