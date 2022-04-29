package br.gov.ce.sps.oisol.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class FotoUsuario {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "usuario_id")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Usuario usuario;
	
	private String nomeArquivo;
	private String descricao;
	private String contentType;
	private Long tamanho;
	
}
