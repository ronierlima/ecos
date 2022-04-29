package br.gov.ce.sps.oisol.api.assembler;

import br.gov.ce.sps.oisol.api.model.input.ModeloInput;
import br.gov.ce.sps.oisol.domain.model.Modelo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModeloInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Modelo toDomainObject(ModeloInput modeloInput) {
		return modelMapper.map(modeloInput, Modelo.class);
	}
	
	public void copyToDomainObject(ModeloInput modeloInput, Modelo modelo) {
		modelMapper.map(modeloInput, modelo);
	}
}
