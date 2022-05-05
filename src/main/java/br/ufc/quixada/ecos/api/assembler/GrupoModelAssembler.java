package br.ufc.quixada.ecos.api.assembler;

import br.ufc.quixada.ecos.domain.model.Grupo;
import br.ufc.quixada.ecos.api.model.GrupoModel;
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
