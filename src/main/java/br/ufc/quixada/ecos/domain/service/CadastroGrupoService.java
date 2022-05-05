package br.ufc.quixada.ecos.domain.service;

import br.ufc.quixada.ecos.domain.exception.EntidadeEmUsoException;
import br.ufc.quixada.ecos.domain.exception.EntidadeNaoEncontradaException;
import br.ufc.quixada.ecos.domain.model.Grupo;
import br.ufc.quixada.ecos.domain.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CadastroGrupoService {

	private static final String MSG_GRUPO_EM_USO = "Grupo de código %s não pode ser removido, pois está em uso";
	
	private static final String MSG_GRUPO_NAO_ENCONTRADO = "Não existe um cadastro de Grupo com código %s";

	@Autowired
	private GrupoRepository grupoRepository;
	
	@Transactional
	public Grupo salvar(Grupo grupo) {
		return grupoRepository.save(grupo);
	}
	
	@Transactional
	public void excluir(UUID codigoGrupo) {
		try {
			Grupo grupo = buscarOuFalhar(codigoGrupo);
			grupoRepository.delete(grupo);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(MSG_GRUPO_NAO_ENCONTRADO, codigoGrupo));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_GRUPO_EM_USO, codigoGrupo));
		}
	}
	
	public Grupo buscarOuFalhar(UUID codigoGrupo) {
		return grupoRepository.findByCodigo(codigoGrupo)
			.orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(MSG_GRUPO_NAO_ENCONTRADO, codigoGrupo)));
	}
}
