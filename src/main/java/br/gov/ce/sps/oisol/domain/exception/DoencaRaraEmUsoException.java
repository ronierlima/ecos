package br.gov.ce.sps.oisol.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DoencaRaraEmUsoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DoencaRaraEmUsoException(String mensagem) {
		super(mensagem);
	}
}
