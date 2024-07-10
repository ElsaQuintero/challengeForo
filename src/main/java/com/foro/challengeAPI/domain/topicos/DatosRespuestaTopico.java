package com.foro.challengeAPI.domain.topicos;

import com.foro.challengeAPI.domain.usuarios.DatosUsuario;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Estado status,
        String curso,
        DatosUsuario usuario
) {
}
