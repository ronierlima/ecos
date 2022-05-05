package br.ufc.quixada.ecos.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DeficienciaEmUsoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DeficienciaEmUsoException(String mensagem) {
		super(mensagem);
	}
}
