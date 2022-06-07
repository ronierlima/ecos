package br.ufc.quixada.ecos.core.security.authorizationserver;

import br.ufc.quixada.ecos.domain.model.Usuario;
import br.ufc.quixada.ecos.domain.repository.UsuarioRepository;
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
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = getUsuario(username);
		
		return new AuthUser(usuario, getAuthorities());
	}

	private Usuario getUsuario(String username) {

		Usuario usuario = usuarioRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o login informado"));
				
		if(!usuario.getAtivo()) {
			throw new AccessDeniedException("Usuário inativo");
		}

		return usuario;
	}

	private Collection<GrantedAuthority> getAuthorities() {
		Set<String> roles = new HashSet<>();
		roles.add("READ");
		roles.add("WRITE");

		return roles.stream()
				.map(role -> new SimpleGrantedAuthority(role))
				.collect(Collectors.toSet());
	}
}
