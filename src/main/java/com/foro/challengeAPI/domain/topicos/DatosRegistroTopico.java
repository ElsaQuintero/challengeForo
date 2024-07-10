package com.foro.challengeAPI.domain.topicos;

import com.foro.challengeAPI.domain.usuarios.DatosUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        String fechaCreacion,
        @NotNull
        Estado status,
        @NotBlank
        String curso,
        @NotNull
        @Valid
        DatosUsuario usuario
) {
}
