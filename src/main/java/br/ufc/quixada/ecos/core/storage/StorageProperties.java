package br.ufc.quixada.ecos.core.storage;

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
        private Path anexos;
    }

    @Getter
    @Setter
    public class Minio {

        private String accessSecret;
        private String accessName;
        private String url;
        private String bucketName;
        private String defaultFolder;
    }
}
