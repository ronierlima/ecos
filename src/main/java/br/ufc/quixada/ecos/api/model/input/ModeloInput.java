package br.ufc.quixada.ecos.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ModeloInput {

	@NotBlank
	private String titulo;
	private String descricao;
	private Boolean privado;
}
