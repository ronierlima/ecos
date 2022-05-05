package br.ufc.quixada.ecos.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RendaNaoEncontradoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public RendaNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
