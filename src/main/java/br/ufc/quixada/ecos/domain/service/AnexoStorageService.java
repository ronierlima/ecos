package br.ufc.quixada.ecos.domain.service;

import lombok.Builder;
import lombok.Getter;

import java.io.InputStream;

public interface AnexoStorageService {

    InputStream recuperar(String nomeArquivo);

    void armazenarCaminho(NovoAnexo novoAnexo, String caminhoRelativo);

    void removerCaminho(String nomeAnexo, String caminhoRelativo);


    @Builder
    @Getter
    class NovoAnexo {
        private String nomeArquivo;
        private InputStream inputStream;
    }
}
