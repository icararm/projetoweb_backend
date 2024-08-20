package com.projetoweb_backend.projetoweb_backend_2.usuario.service;


import com.projetoweb_backend.projetoweb_backend_2.usuario.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioIService {

    public Page<Usuario> findAll(Pageable pageable);

    public Usuario findById(Long id);

    public Usuario save(Usuario usuario);

    public void delete(Long id);

    public Usuario update(Usuario usuario);

}
