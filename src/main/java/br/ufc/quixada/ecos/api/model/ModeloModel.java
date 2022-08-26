package br.ufc.quixada.ecos.api.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

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
