package br.gov.ce.sps.oisol.api.controller;

import br.gov.ce.sps.oisol.api.assembler.GrupoInputDisassembler;
import br.gov.ce.sps.oisol.api.assembler.GrupoModelAssembler;
import br.gov.ce.sps.oisol.domain.service.CadastroModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/modelos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ModeloController {

	@Autowired
	private CadastroModeloService cadastroModelo;
	
	@Autowired
	private GrupoModelAssembler grupoModelAssembler;
	
	@Autowired
	private GrupoInputDisassembler grupoInputDisassembler;

}
