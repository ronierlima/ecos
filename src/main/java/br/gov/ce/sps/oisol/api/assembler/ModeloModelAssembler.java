package br.gov.ce.sps.oisol.api.assembler;

import br.gov.ce.sps.oisol.api.model.GrupoModel;
import br.gov.ce.sps.oisol.api.model.ModeloModel;
import br.gov.ce.sps.oisol.domain.model.Grupo;
import br.gov.ce.sps.oisol.domain.model.Modelo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ModeloModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public ModeloModel toModel(Modelo modelo) {
		return modelMapper.map(modelo, ModeloModel.class);
	}
	
	public Set<ModeloModel> toCollectionModel(Set<Modelo> modelos) {
		return modelos.stream()
				.map(modelo -> toModel(modelo))
				.collect(Collectors.toSet());
	}
}
