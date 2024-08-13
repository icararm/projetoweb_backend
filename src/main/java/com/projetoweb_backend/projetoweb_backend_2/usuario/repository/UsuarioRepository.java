package com.projetoweb_backend.projetoweb_backend_2.usuario.repository;

import com.projetoweb_backend.projetoweb_backend_2.usuario.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
