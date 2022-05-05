package br.ufc.quixada.ecos.api.model.input;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UsuarioInput {

	@NotBlank
	private String nome;
	
	@NotBlank
	private String login;
	
	@Email
	@NotBlank
	private String email;

	@CPF
	private String cpf;
	
	@CNPJ
	private String cnpj;

	private String cargo;

	private String telefone;

}
