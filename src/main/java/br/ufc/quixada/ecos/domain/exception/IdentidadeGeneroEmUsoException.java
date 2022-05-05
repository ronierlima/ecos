package br.ufc.quixada.ecos.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class IdentidadeGeneroEmUsoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public IdentidadeGeneroEmUsoException(String mensagem) {
        super(mensagem);
    }
}

