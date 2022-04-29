package br.gov.ce.sps.oisol.domain.service;

import lombok.Builder;
import lombok.Getter;

import java.io.InputStream;

public interface AnexoStorageService {

    InputStream recuperar(String nomeArquivo);

    void armazenarCaminho(NovoAnexo novoAnexo, String caminhoRelativo);

    void removerCaminho(String nomeAnexo, String caminhoRelativo);

    void limparPasta(String caminho);

    @Builder
    @Getter
    class NovoAnexo {
        private String nomeArquivo;
        private InputStream inputStream;
    }
}
