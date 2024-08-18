package com.projetoweb_backend.projetoweb_backend_2.usuario.service;

import com.projetoweb_backend.projetoweb_backend_2.infrastructure.exception.BusinessException;
import com.projetoweb_backend.projetoweb_backend_2.usuario.entity.Usuario;
import com.projetoweb_backend.projetoweb_backend_2.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public Page<Usuario> findAll(Pageable pageable){
        return usuarioRepository.findAll(pageable);
    }
/*
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }
*/
    public Usuario findById(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new BusinessException("Recurso não encontrado"));
    }
    @Transactional
    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }



}
