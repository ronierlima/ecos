package br.gov.ce.sps.oisol.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class GrupoModel {

	private UUID codigo;
	private String nome;
	private List<PermissaoModel> permissoes;
}
