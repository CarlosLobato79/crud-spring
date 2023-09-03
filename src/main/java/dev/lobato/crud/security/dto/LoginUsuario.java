package dev.lobato.crud.security.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginUsuario {

    @NotBlank
    private String usuario;
    @NotBlank
    private String password;
}
