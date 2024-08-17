package com.projetoweb_backend.projetoweb_backend_2.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPostRequestDto {

    @JsonProperty(value = "nome")
    @NotNull(message = "nome é obrigatório!")
    @NotBlank(message = "nome não pode ser vazio!")
    private String nome;

    @JsonProperty(value = "email")
    @Email(message = "email inválido!")
    private String email;

    @JsonProperty(value = "senha")
    @NotNull(message = "senha é obrigatória!")
    @NotBlank(message = "senha não pode ser vazia!")
    private String senha;

    @JsonProperty(value = "user_name")
    @NotNull(message = "user é obrigatório!")
    @NotBlank(message = "user não pode ser vazio!")
    @Size(min = 3, max = 30, message = "user precisa " +
            "ter pelo menos 3 caracteres e 30 no máximo!")
    private String user_name;
}
