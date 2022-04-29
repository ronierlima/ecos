package br.gov.ce.sps.oisol.core.security.authorizationserver;

import br.gov.ce.sps.oisol.domain.model.Usuario;
import br.gov.ce.sps.oisol.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = getUsuario(username);
		
		return new AuthUser(usuario, getAuthorities(usuario));
	}

	private Usuario getUsuario(String username) {

		Usuario usuario = usuarioRepository.findByLogin(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o login informado"));
				
		if(!usuario.getAtivo()) {
			throw new AccessDeniedException("Usuário inativo");
		}

		if(usuario.getGrupos().isEmpty()) {
			throw new AccessDeniedException("Usuário não está associado a nenhum grupo");
		}
		return usuario;
	}
	
	private Collection<GrantedAuthority> getAuthorities(Usuario usuario) {
		return usuario.getGrupos().stream()
				.map(grupo -> new SimpleGrantedAuthority(grupo.getNome().toUpperCase()))
				.collect(Collectors.toSet());
	}
}
