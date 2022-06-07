package br.ufc.quixada.ecos.domain.filter;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ModeloFilter {

	private UUID codigo;
	private Boolean privado;
	private UUID codigoUsuario;
}
