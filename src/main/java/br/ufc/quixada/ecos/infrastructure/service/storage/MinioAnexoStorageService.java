package br.ufc.quixada.ecos.infrastructure.service.storage;

import br.ufc.quixada.ecos.core.storage.StorageProperties;
import br.ufc.quixada.ecos.domain.service.AnexoStorageService;
import io.minio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class MinioAnexoStorageService implements AnexoStorageService {


    @Autowired
    private MinioClient minioClient;

    @Autowired
    private StorageProperties storageProperties;

    @Override
    public InputStream recuperar(String nomeArquivo) {
        return null;
    }

    @Override
    public void armazenarCaminho(NovoAnexo novoAnexo, String caminhoRelativo) {

        try {

            String caminhoArquivo = caminhoRelativo + novoAnexo.getNomeArquivo();

            InputStream is = novoAnexo.getInputStream();

            ObjectWriteResponse response =  minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(storageProperties.getMinio().getBucketName())
                            .object(caminhoArquivo)
                            .stream(is, is.available(), -1)
                            .build()
            );
           //String nome = String.valueOf(response.object()).replace(caminhoRelativo, "");

        } catch (Exception e) {
            throw new StorageException(e.getMessage());
        }
    }

    @Override
    public void removerCaminho(String nomeAnexo, String caminhoRelativo) {

    }

    @Override
    public void limparPasta(String caminho) {

    }

}
