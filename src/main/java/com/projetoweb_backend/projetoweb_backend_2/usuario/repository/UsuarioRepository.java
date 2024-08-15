package com.projetoweb_backend.projetoweb_backend_2.usuario.repository;

import com.projetoweb_backend.projetoweb_backend_2.usuario.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public List<Usuario> findByName();

    public List<Usuario> findByEmail();
}
