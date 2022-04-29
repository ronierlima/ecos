package br.gov.ce.sps.oisol.api.controller;

import br.gov.ce.sps.oisol.api.model.PermissaoModel;
import br.gov.ce.sps.oisol.core.security.CheckSecurity;
import br.gov.ce.sps.oisol.domain.model.Grupo;
import br.gov.ce.sps.oisol.domain.service.CadastroGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(path = "/grupos/{codigoGrupo}/permissoes", produces = MediaType.APPLICATION_JSON_VALUE)
public class GrupoPermissaoController {

	@Autowired
	private CadastroGrupoService cadastroGrupo;

}
