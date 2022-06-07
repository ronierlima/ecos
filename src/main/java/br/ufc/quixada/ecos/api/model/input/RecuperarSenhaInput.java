package br.ufc.quixada.ecos.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class RecuperarSenhaInput {

	@Email
	@NotBlank
	private String email;
}
