package br.ufc.quixada.ecos.core.springfox.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageableModelSwagger {

    private int page;
    private int size;
    private List<String> sort;
    
}
