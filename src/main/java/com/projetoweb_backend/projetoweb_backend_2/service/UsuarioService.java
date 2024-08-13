package com.projetoweb_backend.projetoweb_backend_2.service;

import com.projetoweb_backend.projetoweb_backend_2.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    public List<Usuario> findAll(){return UsuarioIService.findAll();}

}
