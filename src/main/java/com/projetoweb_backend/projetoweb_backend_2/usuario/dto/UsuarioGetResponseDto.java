package com.projetoweb_backend.projetoweb_backend_2.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioGetResponseDto{

    @JsonProperty(value = "nome")
    /* Especifica o nome da propriedade JSON
    que será mapeada para o campo 'nome' quando
     o objeto for convertido para JSON.
     */
    private String nome;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "senha")
    private String senha;

    @JsonProperty(value = "user_name")
    private String user_name;

}
