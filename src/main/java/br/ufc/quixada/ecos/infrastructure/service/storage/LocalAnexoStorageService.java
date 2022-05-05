package br.ufc.quixada.ecos.infrastructure.service.storage;

import br.ufc.quixada.ecos.core.storage.StorageProperties;
import br.ufc.quixada.ecos.domain.service.AnexoStorageService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

//@Service
public class LocalAnexoStorageService implements AnexoStorageService {

    @Autowired
    private StorageProperties storageProperties;

    @Override
    public void armazenarCaminho(NovoAnexo novoAnexo, String caminhoRelativo) {

        try {
            Path diretorioPath = getAbsolutPath(caminhoRelativo);
            Path arquivoPath = getAbsolutPath((diretorioPath + "/" + novoAnexo.getNomeArquivo()));
            File directory = new File(diretorioPath.toString());

            if (!directory.exists()){
                directory.mkdirs();
            }

            FileCopyUtils.copy(novoAnexo.getInputStream(), Files.newOutputStream(arquivoPath));

        } catch (Exception e) {
            throw new StorageException("Não foi possível armazenar o arquivo.", e);
        }
    }

    @Override
    public InputStream recuperar(String nomeArquivo) {
        try {
            Path arquivoPath = getAbsolutPath(nomeArquivo);

            return Files.newInputStream(arquivoPath);
        } catch (Exception e) {
            throw new StorageException("Não foi possível recuperar arquivo.", e);
        }
    }

    @Override
    public void removerCaminho(String nomeAnexo, String caminhoRelativo) {

            try {
                Path diretorioPath = getAbsolutPath(caminhoRelativo);
                Path arquivoPath = getAbsolutPath((diretorioPath + "/" + nomeAnexo));
                Files.deleteIfExists(arquivoPath);

            } catch (Exception e) {
                throw new StorageException("Não foi possível excluir arquivo.", e);
            } finally {
                limparDiretoriosVazios();
            }
    }

    @Override
    public void limparPasta(String caminho) {

        try {
            Path diretorioPath = getAbsolutPath(caminho);
            FileUtils.deleteDirectory(diretorioPath.toFile());
        } catch (Exception e) {
            throw new StorageException("Não foi possível excluir pasta.", e);
        } finally {
            limparDiretoriosVazios();
        }
    }

    private Path getAbsolutPath(String nomeArquivo) {
        return storageProperties.getLocal().getAnexos().resolve(Path.of(nomeArquivo));
    }

    private boolean limparDiretoriosVazios() {
        if (Files.isDirectory(storageProperties.getLocal().getAnexos())) {
            try {
                Files.walk(storageProperties.getLocal().getAnexos())
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .filter(File::isDirectory)
                        .forEach(File::delete);

            } catch (Exception e) {
                throw new StorageException("Não foi possível excluir arquivo.", e);
            }
        }

        return false;
    }
}
