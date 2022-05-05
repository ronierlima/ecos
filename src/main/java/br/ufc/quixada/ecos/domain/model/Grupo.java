package br.ufc.quixada.ecos.domain.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Audited
@JsonRootName("grupo")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Grupo {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@EqualsAndHashCode.Include
	private UUID codigo;
	
	@NotBlank
	private String nome;

	private Boolean ativo = true;

	@CreationTimestamp
	@Column(name = "data_cadastro")
	private OffsetDateTime dataCadastro;

	@UpdateTimestamp
	@Column(name = "data_atualizacao")
	private OffsetDateTime dataAtualizacao;

	@PrePersist
	private void gerarCodigo() {
		setCodigo(UUID.randomUUID());
	}

}
