package br.gov.ce.sps.oisol.api.model.input;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AnexoInput {

    @NotNull
    private MultipartFile arquivo;
}
