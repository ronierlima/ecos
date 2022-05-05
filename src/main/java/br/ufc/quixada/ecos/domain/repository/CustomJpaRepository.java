package br.ufc.quixada.ecos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface CustomJpaRepository<T, ID> extends JpaRepository<T, ID> {

	Optional<T> buscarPrimeiro();
	
	Optional<T> buscarUltimo();
	
	void detach(T entity);
	
}