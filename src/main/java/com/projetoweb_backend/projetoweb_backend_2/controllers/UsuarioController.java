package com.projetoweb_backend.projetoweb_backend_2.controllers;

import com.projetoweb_backend.projetoweb_backend_2.dto.RequestUsuario;
import com.projetoweb_backend.projetoweb_backend_2.service.UsuarioIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private final UsuarioIService service

    @GetMapping
    public ResponseEntity getAllUsuario(){
        var allUsuarios = repository.findAll();
        return ResponseEntity.ok(allUsuarios);
    }

    @PostMapping
    public ResponseEntity registerUsuarios(@RequestBody @Validated RequestUsuario data){
        Usuario newUsuario
        System.out.println(data);
        re
        return ResponseEntity.ok().build();
    }
}
