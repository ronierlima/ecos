package br.gov.ce.sps.oisol.core.storage;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Getter
@Setter
@Component
@ConfigurationProperties("ecos.storage")
public class StorageProperties {

    private Local local = new Local();
    private Minio minio = new Minio();

    @Getter
    @Setter
    public class Local {
        private Path diretorio;
    }

    @Getter
    @Setter
    public class Minio {

        private String accessKey;
        private String accessSecret;
        private String url;
        private String bucket;
    }
}
