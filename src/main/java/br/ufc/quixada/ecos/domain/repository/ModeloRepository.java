package br.ufc.quixada.ecos.domain.repository;

import br.ufc.quixada.ecos.domain.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long>, JpaSpecificationExecutor<Modelo> {

	Optional<Modelo> findByCodigo(UUID codigoModelo);

}
