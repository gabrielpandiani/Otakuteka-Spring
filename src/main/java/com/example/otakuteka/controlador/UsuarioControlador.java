package com.example.otakuteka.controlador;

import com.example.otakuteka.entidad.Usuarios;
import com.example.otakuteka.negocio.mapper.UsuarioMapper;
import com.example.otakuteka.servicio.UsuarioServiImpl;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;
@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "Allowed actios for the User Entity", tags = "User Controller")
public class UsuarioControlador {

    private final UsuarioServiImpl servi;

    private final UsuarioMapper uMap;

    public UsuarioControlador(UsuarioServiImpl servi, UsuarioMapper uMap){
        this.servi = servi;
        this.uMap = uMap;
    }

    @GetMapping("/todos/{id}")
    public Optional<Usuarios> find(@PathVariable("id")Integer id){
        return servi.findById(id);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> add(@RequestBody Usuarios valor){
        if (!(valor.getNombre().isBlank())&&!(valor.getContrasenia().isBlank())&&!(valor.getEmail().isBlank())){
            return ResponseEntity.status(HttpStatus.CREATED).body(uMap.entityToDTO(this.servi.add(valor)));
        }else if ((valor.getNombre().isEmpty())||(valor.getContrasenia().isEmpty())||(valor.getEmail().isEmpty())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Campos Incompletos");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Credenciales ya existentes");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuarios valor){

            boolean esCorrecto = this.servi.validarUsuario(valor);
            if (esCorrecto){
                return ResponseEntity.ok(true);}
            else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
            }

    }

    @PutMapping("/actualizar")
    public Usuarios find(@RequestBody Usuarios valor){
        return servi.add (valor);
    }

    @DeleteMapping("/borrar/{id}")
    public String delete(@PathVariable("id")Integer id){
        servi.delete(id);
        return "Usuario Eliminado";
    }
}
