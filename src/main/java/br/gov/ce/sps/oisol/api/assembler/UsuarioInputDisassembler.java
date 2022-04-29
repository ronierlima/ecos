package br.gov.ce.sps.oisol.api.assembler;

import br.gov.ce.sps.oisol.api.model.input.UsuarioInput;
import br.gov.ce.sps.oisol.domain.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UsuarioInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Usuario toDomainObject(UsuarioInput usuarioInput) {
		return modelMapper.map(usuarioInput, Usuario.class);
	}
	
	public void copyToDomainObject(UsuarioInput usuarioInput, Usuario usuario) {
		
		modelMapper.map(usuarioInput, usuario);
	}
}
