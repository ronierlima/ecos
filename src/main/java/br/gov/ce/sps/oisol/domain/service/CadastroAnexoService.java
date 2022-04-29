package br.gov.ce.sps.oisol.domain.service;

import br.gov.ce.sps.oisol.domain.exception.EntidadeNaoEncontradaException;
import br.gov.ce.sps.oisol.domain.model.Anexo;
import br.gov.ce.sps.oisol.domain.repository.AnexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CadastroAnexoService {

	private static final String MSG_ANEXO_NAO_ENCONTRADO = "Não existe um cadastro de anexo com código %s";

	@Autowired
	private AnexoRepository anexoRepository;

	@Transactional
	public Anexo salvar(Anexo anexo) {
		return anexoRepository.save(anexo);
	}

	public Anexo buscarOuFalhar(UUID codigoAnexo) {
		return anexoRepository.findByCodigo(codigoAnexo).orElseThrow(
				() -> new EntidadeNaoEncontradaException(String.format(MSG_ANEXO_NAO_ENCONTRADO, codigoAnexo)));
	}

	@Transactional
	public void excluir(UUID codigoGrupo) {
		try {
			Anexo anexo = buscarOuFalhar(codigoGrupo);
			anexoRepository.delete(anexo);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(MSG_ANEXO_NAO_ENCONTRADO, codigoGrupo));
		}
	}
	
}
