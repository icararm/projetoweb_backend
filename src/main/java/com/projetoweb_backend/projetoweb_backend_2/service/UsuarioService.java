package com.projetoweb_backend.projetoweb_backend_2.service;

import com.projetoweb_backend.projetoweb_backend_2.dto.RequestUsuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "usuario")
@Entity(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioService {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private int id;

    private String name;

    public Usuario(RequestUsuario requestUsuario){
        this.name = requestUsuario.name();
    }
}
