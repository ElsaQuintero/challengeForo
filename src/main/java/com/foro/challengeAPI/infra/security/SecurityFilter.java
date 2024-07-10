package com.foro.challengeAPI.infra.security;

import com.foro.challengeAPI.domain.ingresos.IngresoRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private IngresoRepository ingresoRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Obtener el token del header
        var authHeader = request.getHeader("Authorization");
        if (authHeader != null){
            var token = authHeader.replace("Bearer", "");
            var nombreUsuario = tokenService.getSubject(token); //extreaemos el username
            if (nombreUsuario != null) {
                // Token valido
                var ingreso = ingresoRepository.findByLogin(nombreUsuario);
                var authentication = new UsernamePasswordAuthenticationToken(ingreso, null,
                        ingreso.getAuthorities()); // Forzamos el incio de sesion
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request,response);
    }
}
