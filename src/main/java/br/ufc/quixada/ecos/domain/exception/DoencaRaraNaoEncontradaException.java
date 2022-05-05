package br.ufc.quixada.ecos.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DoencaRaraNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DoencaRaraNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
}
