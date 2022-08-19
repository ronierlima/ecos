package br.ufc.quixada.ecos.core.storage;

import io.minio.MinioClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioClientConfig {

    @Autowired
    private StorageProperties storageProperties;

    @Bean
    public MinioClient generateMinioClient() {
        try {

            MinioClient client = MinioClient.builder()
                    .endpoint(storageProperties.getMinio().getUrl()).credentials(storageProperties.getMinio().getName(), storageProperties.getMinio().getSecret())
                    .build();

            return client;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
