package br.gov.ce.sps.oisol.domain.repository;

import br.gov.ce.sps.oisol.domain.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

	Optional<Grupo> findByCodigo(UUID codigoGrupo);

}
