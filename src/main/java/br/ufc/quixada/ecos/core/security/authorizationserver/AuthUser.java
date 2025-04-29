package br.ufc.quixada.ecos.core.security.authorizationserver;

import br.ufc.quixada.ecos.domain.model.Usuario;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.UUID;

@Getter
public class AuthUser extends User {

private static final long serialVersionUID = 1L;
	
	private UUID userCode;
	private String fullName;
	
	public AuthUser(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getSenha(), authorities);
		
		this.userCode = usuario.getCodigo();
		this.fullName = usuario.getNome();
		
	}
}
