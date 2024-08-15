package com.projetoweb_backend.projetoweb_backend_2.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public record UsuarioGetResponseDto(String name) {

    @JsonProperty(value = "nome")
    private static String nome;

    @JsonProperty(value = "email")
    private static String email;

    @JsonProperty(value = "senha")
    private static String senha;

    @JsonProperty(value = "user_name")
    private static String user_name;


}
