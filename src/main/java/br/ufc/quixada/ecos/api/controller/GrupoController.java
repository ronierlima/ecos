package br.ufc.quixada.ecos.api.controller;

import br.ufc.quixada.ecos.domain.model.Grupo;
import br.ufc.quixada.ecos.api.assembler.GrupoInputDisassembler;
import br.ufc.quixada.ecos.api.assembler.GrupoModelAssembler;
import br.ufc.quixada.ecos.api.model.GrupoModel;
import br.ufc.quixada.ecos.api.model.input.GrupoInput;
import br.ufc.quixada.ecos.core.security.CheckSecurity;
import br.ufc.quixada.ecos.domain.repository.GrupoRepository;
import br.ufc.quixada.ecos.domain.service.CadastroGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(path = "/grupos", produces = MediaType.APPLICATION_JSON_VALUE)
public class GrupoController {

	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private CadastroGrupoService cadastroGrupo;
	
	@Autowired
	private GrupoModelAssembler grupoModelAssembler;
	
	@Autowired
	private GrupoInputDisassembler grupoInputDisassembler;

	@GetMapping
	public Set<GrupoModel> listar() {
		Set<Grupo> todosGrupos = Set.copyOf(grupoRepository.findAll());
		
		return grupoModelAssembler.toCollectionModel(todosGrupos);
	}
	
	@CheckSecurity.Usuarios.PodeGerenciar
	@GetMapping("/{codigoGrupo}")
	public GrupoModel buscar(@PathVariable UUID codigoGrupo) {
		Grupo grupo = cadastroGrupo.buscarOuFalhar(codigoGrupo);
		
		return grupoModelAssembler.toModel(grupo);
	}
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public GrupoModel adicionar(@RequestBody @Valid GrupoInput grupoInput) {
		Grupo grupo = grupoInputDisassembler.toDomainObject(grupoInput);
		
		grupo = cadastroGrupo.salvar(grupo);
		
		return grupoModelAssembler.toModel(grupo);
	}
	

	@PutMapping("/{codigoGrupo}")
	public GrupoModel atualizar(@PathVariable UUID codigoGrupo,
			@RequestBody @Valid GrupoInput grupoInput) {
		Grupo grupoAtual = cadastroGrupo.buscarOuFalhar(codigoGrupo);
		
		grupoInputDisassembler.copyToDomainObject(grupoInput, grupoAtual);
		
		grupoAtual = cadastroGrupo.salvar(grupoAtual);
		
		return grupoModelAssembler.toModel(grupoAtual);
	}
	

	@DeleteMapping("/{codigoGrupo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable UUID codigoGrupo) {
		cadastroGrupo.excluir(codigoGrupo);	
	}
}
