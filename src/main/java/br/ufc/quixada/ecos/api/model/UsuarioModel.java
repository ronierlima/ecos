package br.ufc.quixada.ecos.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UsuarioModel {

	private UUID codigo;
	private String nome;
	private String email;
	private String instituicao;
	private Boolean ativo;
	private AnexoModel fotoPerfil;
	private List<ModeloModel> modelos;
}
