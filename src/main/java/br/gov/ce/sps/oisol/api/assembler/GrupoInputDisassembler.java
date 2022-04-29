package br.gov.ce.sps.oisol.api.assembler;

import br.gov.ce.sps.oisol.api.model.input.GrupoInput;
import br.gov.ce.sps.oisol.domain.model.Grupo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GrupoInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Grupo toDomainObject(GrupoInput grupoInput) {
		return modelMapper.map(grupoInput, Grupo.class);
	}
	
	public void copyToDomainObject(GrupoInput grupoInput, Grupo grupo) {
		modelMapper.map(grupoInput, grupo);
	}
}
