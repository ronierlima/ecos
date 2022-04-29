package br.gov.ce.sps.oisol.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DeficienciaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DeficienciaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
}
