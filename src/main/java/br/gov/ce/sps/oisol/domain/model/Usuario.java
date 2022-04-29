package br.gov.ce.sps.oisol.domain.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

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
	
	@NotBlank
	private String login;

	@Email
	@NotBlank
	private String email;

	@NotBlank
	private String senha;
	
	@ManyToMany
	@JoinTable(name = "usuario_grupo", joinColumns = @JoinColumn(name = "usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "grupo_id"))
	private Set<Grupo> grupos = new HashSet<>();

	private String instituicao;

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
	
	public boolean removerGrupo(Grupo grupo) {
		return getGrupos().remove(grupo);
	}
	
	public boolean adicionarGrupo(Grupo grupo) {
		return getGrupos().add(grupo);
	}
	
	public boolean isNovo() {
		return getId() == null;
	}

	public List<String> getGruposListString() {
		return getGrupos().stream().map(Grupo::getNome).collect(Collectors.toList());
	}
}
