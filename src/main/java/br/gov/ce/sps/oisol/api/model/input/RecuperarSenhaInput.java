package br.gov.ce.sps.oisol.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class RecuperarSenhaInput {

	@NotBlank
	private String login;
	
	@Email
	@NotBlank
	private String email;
}
