package com.projetoweb_backend.projetoweb_backend_2.usuario.controller;

import com.projetoweb_backend.projetoweb_backend_2.usuario.dto.UsuarioGetResponseDto;
import com.projetoweb_backend.projetoweb_backend_2.usuario.dto.UsuarioPostRequestDto;
import com.projetoweb_backend.projetoweb_backend_2.usuario.entity.Usuario;
import com.projetoweb_backend.projetoweb_backend_2.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    // Utilitário para conversão de objetos entre tipos diferentes
    private ObjectMapperUtil objectMapperUtil;

    /**
        Endpoint para listar todos os usuários com paginação.
        pageable Informações de paginação (página, tamanho da página, etc.)
         @return Lista de usuários paginada, convertida para DTOs de resposta
     */
    @GetMapping(path = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<UsuarioGetResponseDto>> findAll(Pageable pageable){
       return ResponseEntity.status(HttpStatus.OK).
               body(this.usuarioService.findAll(pageable).map( c -> objectMapperUtil.
                       map(c, UsuarioGetResponseDto.class)));
    }

    /**
        Endpoint para salvar um novo usuário.
        usuarioPostRequestDto Dados do usuário a serem salvos
        @return O usuário salvo convertido para DTO de resposta, com status 201 Created
     */
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody @Valid UsuarioPostRequestDto usuarioPostRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(objectMapperUtil.map(usuarioService.save(
                        (objectMapperUtil.map(usuarioPostRequestDto, Usuario.class))), UsuarioGetResponseDto.class));
    }

    /**
       Endpoint para atualizar um usuário existente.
       usuario Dados atualizados do usuário
       @return Resposta com status 204 No Content, indicando que a atualização foi bem-sucedida
     */
    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody Usuario usuario){
        usuarioService.update(usuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
       Endpoint para excluir um usuário pelo ID.
       id ID do usuário a ser excluído
       @return Resposta com status 200 OK, indicando que a exclusão foi bem-sucedida
     */
    @DeleteMapping(path = "/delete/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
       usuarioService.delete(id);
       return ResponseEntity.status(HttpStatus.OK).build();
    }

}
