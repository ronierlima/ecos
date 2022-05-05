package br.ufc.quixada.ecos.api.model;

import br.ufc.quixada.ecos.domain.model.Anexo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ModeloModel {

	private UUID codigo;
	private String titulo;
	private UsuarioBasicoModel criador;
	private AnexoModel arquivoModelo;
	private AnexoModel arquivoPreviewModelo;
}
