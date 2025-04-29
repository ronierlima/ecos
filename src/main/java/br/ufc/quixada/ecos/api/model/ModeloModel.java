package br.ufc.quixada.ecos.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class ModeloModel {

	private UUID codigo;
	private String titulo;
	private String descricao;
	private OffsetDateTime dataAtualizacao;
	private OffsetDateTime dataCadastro;
	private UsuarioBasicoModel criador;
	private AnexoModel arquivoModelo;
	private AnexoModel arquivoPreviewModelo;
}
