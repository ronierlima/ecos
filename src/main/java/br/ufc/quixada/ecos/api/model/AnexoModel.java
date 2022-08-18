package br.ufc.quixada.ecos.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AnexoModel {

    private UUID codigo;
    private String contentType;
    private Long tamanho;
}
