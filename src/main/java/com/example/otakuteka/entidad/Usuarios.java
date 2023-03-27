package com.example.otakuteka.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="usuarios")
@Getter
@Setter


public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuarios")
    private Integer idusuarios;

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;


    @Column(name = "contrasenia")
    private String contrasenia;

    @Column(name = "email",unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<AnimeHasUsuarios> puntajeHecho;


}
