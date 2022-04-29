package br.gov.ce.sps.oisol.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnexoModel {

    private String nomeArquivo;
    private String contentType;
    private Long tamanho;
}
