package com.projetoweb_backend.projetoweb_backend_2.usuario.controller;

import com.projetoweb_backend.projetoweb_backend_2.usuario.dto.UsuarioGetResponseDto;
import com.projetoweb_backend.projetoweb_backend_2.usuario.dto.UsuarioPostRequestDto;
import com.projetoweb_backend.projetoweb_backend_2.usuario.entity.Usuario;
import com.projetoweb_backend.projetoweb_backend_2.usuario.repository.UsuarioRepository;
import com.projetoweb_backend.projetoweb_backend_2.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.projetoweb_backend.projetoweb_backend_2.infrastructure.mapper.ObjectMapperUtil;
@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;
    private ObjectMapperUtil objectMapperUtil;

    @GetMapping(path = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<UsuarioGetResponseDto>> findAll(Pageable pageable){
       return ResponseEntity.status(HttpStatus.OK).
               body(this.usuarioService.findAll(pageable).map( c -> objectMapperUtil.
                       map(c, UsuarioGetResponseDto.class)));
    }

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody @Valid UsuarioPostRequestDto usuarioPostRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(objectMapperUtil.map(usuarioService.save(
                        (objectMapperUtil.map(usuarioPostRequestDto, Usuario.class))), UsuarioGetResponseDto.class));
    }




}
