package br.gov.ce.sps.oisol.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UsuarioBasicoModel {

	private UUID codigo;
	private String nome;
	private Boolean ativo;
	
}
