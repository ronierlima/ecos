package br.ufc.quixada.ecos.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PessoaEmUsoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PessoaEmUsoException(String mensagem) {
		super(mensagem);
	}
}
