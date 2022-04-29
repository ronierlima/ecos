package br.gov.ce.sps.oisol.core.security.authorizationserver;

import br.gov.ce.sps.oisol.domain.model.Usuario;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
public class AuthUser extends User {

private static final long serialVersionUID = 1L;
	
	private UUID userCode;
	private String fullName;
	private List<String> grupos;
	
	public AuthUser(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getLogin(), usuario.getSenha(), authorities);
		
		this.userCode = usuario.getCodigo();
		this.fullName = usuario.getNome();
		this.grupos = usuario.getGruposListString();
		
	}
}
