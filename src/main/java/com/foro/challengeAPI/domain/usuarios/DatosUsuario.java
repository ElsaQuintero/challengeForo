package com.foro.challengeAPI.domain.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(
        @NotBlank
        String nombre,
        @NotBlank
                @Email
        String email,
        @NotBlank
        String password
) {
}