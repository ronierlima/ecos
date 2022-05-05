package br.ufc.quixada.ecos.domain.repository;

import br.ufc.quixada.ecos.domain.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

	Optional<Grupo> findByCodigo(UUID codigoGrupo);

}
