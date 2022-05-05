package br.ufc.quixada.ecos.api.controller;

import br.ufc.quixada.ecos.api.assembler.GrupoModelAssembler;
import br.ufc.quixada.ecos.core.security.CheckSecurity;
import br.ufc.quixada.ecos.domain.service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/usuarios/{codigoUsuario}/grupos", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioGrupoController {

	@Autowired
	private CadastroUsuarioService cadastroUsuario;
	
	@Autowired
	private GrupoModelAssembler grupoModelAssembler;
	
	@CheckSecurity.Usuarios.PodeGerenciar
	@DeleteMapping("/{codigoGrupo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> desassociar(@PathVariable UUID codigoUsuario, @PathVariable UUID codigoGrupo) {
		cadastroUsuario.desassociarGrupo(codigoUsuario, codigoGrupo);
		
		return ResponseEntity.noContent().build();
	}
	
	@CheckSecurity.Usuarios.PodeGerenciar
	@PutMapping("/{codigoGrupo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> associar(@PathVariable UUID codigoUsuario, @PathVariable UUID codigoGrupo) {
		cadastroUsuario.associarGrupo(codigoUsuario, codigoGrupo);
		
		return ResponseEntity.noContent().build();
	}
}
