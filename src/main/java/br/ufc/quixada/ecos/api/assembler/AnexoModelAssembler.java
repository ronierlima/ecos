package br.ufc.quixada.ecos.api.assembler;

import br.ufc.quixada.ecos.domain.model.Anexo;
import br.ufc.quixada.ecos.api.model.AnexoModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class AnexoModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public AnexoModel toModel(Anexo anexo) {
		return modelMapper.map(anexo, AnexoModel.class);
	}
	
	public List<AnexoModel> toCollectionModel(List<Anexo> anexos) {
		return anexos.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
}
