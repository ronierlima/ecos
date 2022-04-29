package br.gov.ce.sps.oisol.domain.model;

import br.gov.ce.sps.oisol.domain.listener.CustomRevisionListener;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;

@Table(name="revinfo")
@Entity
@Getter @Setter
@RevisionEntity(CustomRevisionListener.class)
public class CustomRevisionEntity extends DefaultRevisionEntity {
	
	private static final long serialVersionUID = 1L;

	/*
	Valores revtype
		0 - Criado/Novo
		1 - Editado
		2 - Excluido
	*/	

	@Column(name = "codigo_usuario")
	private UUID codigoUsuario;
	
	@Column(name = "nome_usuario")
	private String nomeUsuario;
	
	@CreationTimestamp
	@Column(name = "data_cadastro")
	private OffsetDateTime dataCadastro;
}
