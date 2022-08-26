package br.ufc.quixada.ecos.domain.service;

import br.ufc.quixada.ecos.core.security.EcosSecurity;
import br.ufc.quixada.ecos.domain.exception.NegocioException;
import br.ufc.quixada.ecos.domain.repository.ModeloRepository;
import br.ufc.quixada.ecos.domain.exception.EntidadeEmUsoException;
import br.ufc.quixada.ecos.domain.exception.EntidadeNaoEncontradaException;
import br.ufc.quixada.ecos.domain.model.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.UUID;

@Service
public class CadastroModeloService {

    private static final String MSG_MODELO_EM_USO = "Modelo com o código %s não pode ser removido, pois está em uso";

    private static final String MSG_MODELO_NAO_ENCONTRADO = "Não existe um cadastro de Modelo com código %s";

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private CadastroUsuarioService cadastroUsuario;

    @Autowired
    private AnexoStorageService anexoStorageService;

    @Autowired
    private EcosSecurity security;

    @Transactional
    public Modelo salvar(Modelo modelo, InputStream modeloArquivo, InputStream preview) {

        modelo.setUsuario(this.cadastroUsuario.buscarOuFalhar(this.security.getCodigoUsuario()));

        Modelo modeloSalvo = modeloRepository.save(modelo);

        AnexoStorageService.NovoAnexo novoAnexoModelo = AnexoStorageService.NovoAnexo.builder()
                .nomeArquivo(modelo.getArquivoModelo().getCodigo().toString())
                .inputStream(modeloArquivo).build();

        anexoStorageService.armazenarCaminho(novoAnexoModelo, "modelos/");

        if(preview != null && modelo.getArquivoPreviewModelo() != null) {

            novoAnexoModelo = AnexoStorageService.NovoAnexo.builder()
                    .nomeArquivo(modelo.getArquivoPreviewModelo().getCodigo().toString())
                    .inputStream(preview).build();

            anexoStorageService.armazenarCaminho(novoAnexoModelo, "previews/");
        }

        return modeloSalvo;
    }
    @Transactional
    public void excluir(UUID codigoModelo) {
        try {
            Modelo modelo = buscarOuFalhar(codigoModelo);
            modeloRepository.delete(modelo);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format(MSG_MODELO_NAO_ENCONTRADO, codigoModelo));
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(MSG_MODELO_EM_USO, codigoModelo));
        }
    }
    public Modelo buscarOuFalhar(UUID codigoModelo) {
        return modeloRepository.findByCodigo(codigoModelo)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(MSG_MODELO_NAO_ENCONTRADO, codigoModelo)));
    }

}
