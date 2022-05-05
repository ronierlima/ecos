package br.ufc.quixada.ecos.api.controller;

import br.ufc.quixada.ecos.domain.service.CadastroGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/grupos/{codigoGrupo}/permissoes", produces = MediaType.APPLICATION_JSON_VALUE)
public class GrupoPermissaoController {

	@Autowired
	private CadastroGrupoService cadastroGrupo;

}
