package br.gov.ce.sps.oisol.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReligiaoNaoEncontradoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ReligiaoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
