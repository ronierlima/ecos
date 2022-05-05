package br.ufc.quixada.ecos.domain.service;

import br.ufc.quixada.ecos.domain.exception.EntidadeNaoEncontradaException;
import br.ufc.quixada.ecos.domain.model.Anexo;
import br.ufc.quixada.ecos.domain.repository.AnexoRepository;
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
