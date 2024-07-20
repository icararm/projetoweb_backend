package br.com.ifba.usuario.controller;

import br.com.ifba.usuario.service.UsuarioIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/'Usuario")
@RequiredArgsConstructor
public class UsuarioController {

    /*private final UsuarioIService UsuarioService;*/
    private final UsuarioIService service;

    @GetMapping(path = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity.status(HttpStatus.OK).body(br.com.ifba.usuario.service.UsuarioService.findAll())
}
