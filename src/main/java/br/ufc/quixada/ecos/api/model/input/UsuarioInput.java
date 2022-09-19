package br.ufc.quixada.ecos.api.model.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {

	@NotBlank
	private String nome;

	@Email
	@NotBlank
	private String email;

	private String instituicao;

}
