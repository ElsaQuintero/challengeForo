package com.foro.challengeAPI.domain.usuarios;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private String nombre;
    private String email;
    private String password;

    public Usuario(DatosUsuario usuario) {
        this.nombre = usuario.nombre();
        this.email = usuario.email();
        this.password = usuario.password();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
