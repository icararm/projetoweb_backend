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
public class UsuarioService implements UsuarioIService {

    // Declara o repositório usado para operações com a entidade Usuario.
    private UsuarioRepository usuarioRepository;

    // Método para buscar todos os usuários com paginação.
    public Page<Usuario> findAll(Pageable pageable){
        return usuarioRepository.findAll(pageable);
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new BusinessException("Recurso não encontrado"));
    }

    /*
     Métodos básicos: salvar, deletar e atualizar
     Ultilizando o @Transactional
     Garante que a operação seja executada dentro de uma transação
     */

    @Transactional
    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void delete(Long id) {
        Usuario usuario = findById(id);
        usuarioRepository.delete(usuario);
    }

    @Transactional
    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}
