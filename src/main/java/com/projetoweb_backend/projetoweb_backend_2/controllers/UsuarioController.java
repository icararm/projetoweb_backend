package com.projetoweb_backend.projetoweb_backend_2.controllers;

import com.projetoweb_backend.projetoweb_backend_2.service.UsuarioIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioIService service;

    @GetMapping(path = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <?>findAll(){

        return ResponseEntity.status(HttpStatus.OK)
                .body();
    }

}
