package br.ufc.quixada.ecos.api.assembler;

import br.ufc.quixada.ecos.api.model.ModeloModel;
import br.ufc.quixada.ecos.domain.model.Modelo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModeloModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public ModeloModel toModel(Modelo modelo) {
		return modelMapper.map(modelo, ModeloModel.class);
	}
	
	public List<ModeloModel> toCollectionModel(List<Modelo> modelos) {
		return modelos.stream()
				.map(modelo -> toModel(modelo))
				.collect(Collectors.toList());
	}
}
