package br.gov.ce.sps.oisol.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class GrupoCodigoInput {

	@NotBlank
	private UUID codigo;
}
