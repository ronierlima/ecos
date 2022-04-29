package br.gov.ce.sps.oisol.domain.repository;

import br.gov.ce.sps.oisol.domain.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

	Optional<Modelo> findByCodigo(UUID codigoModelo);

}
