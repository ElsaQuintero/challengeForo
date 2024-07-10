package com.foro.challengeAPI.domain.ingresos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IngresoRepository extends JpaRepository<Ingreso, Long> {

    UserDetails findByLogin(String username);
}
