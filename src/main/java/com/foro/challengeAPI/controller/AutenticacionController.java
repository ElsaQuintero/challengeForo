package com.foro.challengeAPI.controller;

import com.foro.challengeAPI.domain.ingresos.DatosAutenticacionIngreso;
import com.foro.challengeAPI.domain.ingresos.Ingreso;
import com.foro.challengeAPI.infra.security.DatosJWTToken;
import com.foro.challengeAPI.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarIngreso(@RequestBody @Valid DatosAutenticacionIngreso datosAutenticacionIngreso) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionIngreso.login(),
                datosAutenticacionIngreso.clave());
        var usuarioAutenticado =  authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Ingreso) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}
