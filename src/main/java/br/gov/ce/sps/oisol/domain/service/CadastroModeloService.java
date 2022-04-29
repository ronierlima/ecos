package br.gov.ce.sps.oisol.domain.service;

import br.gov.ce.sps.oisol.domain.exception.EntidadeEmUsoException;
import br.gov.ce.sps.oisol.domain.exception.EntidadeNaoEncontradaException;
import br.gov.ce.sps.oisol.domain.model.Modelo;
import br.gov.ce.sps.oisol.domain.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CadastroModeloService {

    private static final String MSG_MODELO_EM_USO = "Modelo com o código %s não pode ser removido, pois está em uso";

    private static final String MSG_MODELO_NAO_ENCONTRADO = "Não existe um cadastro de Modelo com código %s";

    @Autowired
    private ModeloRepository modeloRepository;

    @Transactional
    public Modelo salvar(Modelo modelo) {
        return modeloRepository.save(modelo);
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
