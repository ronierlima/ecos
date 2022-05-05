package br.ufc.quixada.ecos.api.assembler;

import br.ufc.quixada.ecos.api.model.input.ModeloInput;
import br.ufc.quixada.ecos.domain.model.Modelo;
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
