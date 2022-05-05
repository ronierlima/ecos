package br.ufc.quixada.ecos.api.model.input;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AnexoInput {

    @NotNull
    private MultipartFile modelo;

    private MultipartFile preview;
}
