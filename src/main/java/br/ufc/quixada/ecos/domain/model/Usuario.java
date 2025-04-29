package br.ufc.quixada.ecos.domain.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.UUID;

@Audited
@JsonRootName("usuario")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Usuario {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID codigo;
	
	@NotBlank
	private String nome;

	@Email
	@NotBlank
	private String email;

	@NotBlank
	private String senha;

	private String instituicao;

	private Boolean ativo = true;

	@CreationTimestamp
	@Column(name = "data_cadastro")
	private OffsetDateTime dataCadastro;

	@UpdateTimestamp
	@Column(name = "data_atualizacao")
	private OffsetDateTime dataAtualizacao;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "foto_id")
	private Anexo fotoPerfil;
	@PrePersist
	private void gerarCodigo() {
		setCodigo(UUID.randomUUID());
	}
	public boolean isNovo() {
		return getId() == null;
	}

}
