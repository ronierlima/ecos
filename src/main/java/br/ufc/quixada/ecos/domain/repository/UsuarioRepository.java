package br.ufc.quixada.ecos.domain.repository;

import br.ufc.quixada.ecos.domain.model.Usuario;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends CustomJpaRepository<Usuario, Long> {
	Optional<Usuario> findByCodigo(UUID codigo);
	Optional<Usuario> findByEmail(String email);

	List<Usuario> findAll();
	List<Usuario> findAll(Sort sort);
}
