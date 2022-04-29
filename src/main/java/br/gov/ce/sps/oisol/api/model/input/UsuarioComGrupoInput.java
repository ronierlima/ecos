package br.gov.ce.sps.oisol.api.model.input;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UsuarioComGrupoInput extends UsuarioInput {
	private Set<GrupoCodigoInput> grupos;
}
