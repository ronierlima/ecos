package br.ufc.quixada.ecos.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UsuarioBasicoModel {

	private UUID codigo;
	private String nome;
	private String email;
	private Boolean ativo;
	
}
