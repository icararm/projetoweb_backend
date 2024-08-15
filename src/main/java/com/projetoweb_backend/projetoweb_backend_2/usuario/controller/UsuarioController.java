package com.projetoweb_backend.projetoweb_backend_2.usuario.controller;

import com.projetoweb_backend.projetoweb_backend_2.usuario.entity.Usuario;
import com.projetoweb_backend.projetoweb_backend_2.usuario.repository.UsuarioRepository;
import com.projetoweb_backend.projetoweb_backend_2.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projetoweb_backend.projetoweb_backend_2.infrastructure.mapper.ObjectMapperUtil;
@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;
    private ObjectMapperUtil objectMapperUtil;

    @GetMapping(path = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll(){
       return ResponseEntity.status(HttpStatus.OK).
               body(usuarioService.findAll());
    }


}
