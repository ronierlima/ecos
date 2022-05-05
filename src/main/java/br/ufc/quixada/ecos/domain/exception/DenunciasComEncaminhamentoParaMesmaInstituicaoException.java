package br.ufc.quixada.ecos.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DenunciasComEncaminhamentoParaMesmaInstituicaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DenunciasComEncaminhamentoParaMesmaInstituicaoException(String mensagem) {
		super(mensagem);
	}
}
