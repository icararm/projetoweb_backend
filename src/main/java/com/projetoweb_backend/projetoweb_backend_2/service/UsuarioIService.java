package com.projetoweb_backend.projetoweb_backend_2.service;

import com.projetoweb_backend.projetoweb_backend_2.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioIService extends JpaRepository <Usuario, Long> {

    public List<Usuario> findByName();

    public List<Usuario> findByEmail();
}
