package br.gov.ce.sps.oisol.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UsuarioModel {

	private UUID codigo;
	private String nome;
	private String login;
	private String email;
	private String instituicao;
	private Boolean ativo;
	private List<GrupoModel> grupos;
	private List<ModeloModel> modelos;
}
