package br.gov.ce.sps.oisol.api.assembler;

import br.gov.ce.sps.oisol.api.model.GrupoModel;
import br.gov.ce.sps.oisol.domain.model.Grupo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GrupoModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public GrupoModel toModel(Grupo grupo) {
		return modelMapper.map(grupo, GrupoModel.class);
	}
	
	public Set<GrupoModel> toCollectionModel(Set<Grupo> grupos) {
		return grupos.stream()
				.map(grupo -> toModel(grupo))
				.collect(Collectors.toSet());
	}
}
