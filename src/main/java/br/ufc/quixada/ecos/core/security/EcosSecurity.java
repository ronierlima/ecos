package br.ufc.quixada.ecos.core.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EcosSecurity {

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public UUID getCodigoUsuario() {
        Jwt jwt = (Jwt) getAuthentication().getPrincipal();

        return UUID.fromString(jwt.getClaim("codigo_usuario"));
    }

    public String getNomeUsuario() {
        Jwt jwt = (Jwt) getAuthentication().getPrincipal();

        return jwt.getClaim("nome_completo");
    }

}

