package br.ufc.quixada.ecos.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class UsuarioCodigoInput {

	@NotNull
	private UUID codigo;
}
