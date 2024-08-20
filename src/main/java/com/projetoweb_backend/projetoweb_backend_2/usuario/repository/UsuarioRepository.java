package com.projetoweb_backend.projetoweb_backend_2.usuario.repository;

import com.projetoweb_backend.projetoweb_backend_2.usuario.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Define uma consulta personalizada para buscar um usuário pelo campo user_name.
    @Query("select u from Usuario u where u.user_name =?1")
    Optional<Usuario> findByUser_name(String user_name);
}
