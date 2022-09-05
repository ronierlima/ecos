package br.ufc.quixada.ecos.api.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.quixada.ecos.api.assembler.ModeloInputDisassembler;
import br.ufc.quixada.ecos.api.assembler.ModeloModelAssembler;
import br.ufc.quixada.ecos.api.model.ModeloModel;
import br.ufc.quixada.ecos.api.model.input.AnexoInput;
import br.ufc.quixada.ecos.api.model.input.ModeloInput;
import br.ufc.quixada.ecos.domain.exception.EntidadeNaoEncontradaException;
import br.ufc.quixada.ecos.domain.filter.ModeloFilter;
import br.ufc.quixada.ecos.domain.model.Anexo;
import br.ufc.quixada.ecos.domain.model.Modelo;
import br.ufc.quixada.ecos.domain.repository.ModeloRepository;
import br.ufc.quixada.ecos.domain.service.AnexoStorageService;
import br.ufc.quixada.ecos.domain.service.CadastroModeloService;
import br.ufc.quixada.ecos.infrastructure.repository.spec.ModeloSpecs;

@RestController
@RequestMapping(path = "/modelos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ModeloController {

	@Autowired
	private CadastroModeloService cadastroModelo;

	@Autowired
	private ModeloRepository modeloRepository;
	
	@Autowired
	private ModeloModelAssembler modeloModelAssembler;
	
	@Autowired
	private ModeloInputDisassembler modeloInputDisassembler;

	@Autowired
	private AnexoStorageService anexoStorageService;

	@GetMapping
	public Page<ModeloModel> pesquisar(ModeloFilter filtro, Pageable pageable) {

		Page<Modelo> modelosPage = modeloRepository.findAll(ModeloSpecs.usandoFiltro(filtro), pageable);

		List<ModeloModel> modelosModel = modeloModelAssembler.toCollectionModel(modelosPage.getContent());

		PageImpl<ModeloModel> modelosModelPage = new PageImpl<>(modelosModel, pageable, modelosPage.getTotalElements());

		return modelosModelPage;
	}

	@GetMapping("/{codigoModelo}")
	public ModeloModel buscar(@PathVariable UUID codigoModelo) {
		return modeloModelAssembler.toModel(cadastroModelo.buscarOuFalhar(codigoModelo));
	}

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ModeloModel criar(@Valid ModeloInput modeloInput, @Valid AnexoInput anexoInput) throws IOException {

		MultipartFile modeloArquivo = anexoInput.getModelo();
		MultipartFile preview = anexoInput.getPreview();

		Anexo modeloAnexo = new Anexo();
		Anexo previewAnexo = new Anexo();

		modeloAnexo.setContentType(modeloArquivo.getContentType());
		modeloAnexo.setTamanho(modeloArquivo.getSize());

		previewAnexo.setContentType(preview.getContentType());
		previewAnexo.setTamanho(preview.getSize());

		Modelo modelo = modeloInputDisassembler.toDomainObject(modeloInput);

		modelo.setArquivoModelo(modeloAnexo);
		modelo.setArquivoPreviewModelo(previewAnexo);

		return modeloModelAssembler.toModel(cadastroModelo.salvar(modelo, modeloArquivo.getInputStream(), preview.getInputStream()));

	}

	@RequestMapping(
			value = "/{codigoModelo}",
			method = RequestMethod.PUT,
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE
	)
	@ResponseStatus(HttpStatus.CREATED)
	public ModeloModel atualizar(@PathVariable UUID codigoModelo, @Valid ModeloInput modeloInput, @Valid AnexoInput anexoInput) throws IOException {

		Modelo modelo = cadastroModelo.buscarOuFalhar(codigoModelo);

		MultipartFile modeloArquivo = anexoInput.getModelo();
		MultipartFile preview = anexoInput.getPreview();

		Anexo modeloAnexo = new Anexo();
		Anexo previewAnexo = new Anexo();

		modeloAnexo.setContentType(modeloArquivo.getContentType());
		modeloAnexo.setTamanho(modeloArquivo.getSize());

		previewAnexo.setContentType(preview.getContentType());
		previewAnexo.setTamanho(preview.getSize());


		modelo.setArquivoModelo(modeloAnexo);
		modelo.setArquivoPreviewModelo(previewAnexo);
		modelo.setDescricao(modeloInput.getDescricao());
		modelo.setTitulo(modeloInput.getTitulo());

		return modeloModelAssembler.toModel(cadastroModelo.salvar(modelo, modeloArquivo.getInputStream(), preview.getInputStream()));

	}

    @PatchMapping("/{codigoModelo}")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloModel atualizarParcial(@PathVariable UUID codigoModelo, @Valid @RequestBody ModeloInput modeloInput) {
        Modelo modelo = cadastroModelo.buscarOuFalhar(codigoModelo);

        modelo.setDescricao(modeloInput.getDescricao());
        modelo.setTitulo(modeloInput.getTitulo());

        return modeloModelAssembler.toModel(cadastroModelo.salvar(modelo));
    }

	@GetMapping(value = "/{codigoModelo}/arquivo")
	public ResponseEntity<InputStreamResource> servirArquivo(@PathVariable UUID codigoModelo) {
		try {
			Modelo modelo = cadastroModelo.buscarOuFalhar(codigoModelo);

			MediaType mediaTypeAnexo = MediaType.parseMediaType(modelo.getArquivoModelo().getContentType());


			InputStream inputStream = anexoStorageService.recuperar("modelos/"  + modelo.getArquivoModelo().getCodigo());

			return ResponseEntity.ok()
					.header("Content-Disposition", "attachment; filename=" + modelo.getTitulo())
					.contentType(mediaTypeAnexo)
					.body(new InputStreamResource(inputStream));

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
	}


	@GetMapping(value = "/{codigoModelo}/preview")
	public ResponseEntity<InputStreamResource> servirPreview(@PathVariable UUID codigoModelo) {
		try {
				Modelo modelo = cadastroModelo.buscarOuFalhar(codigoModelo);

			MediaType mediaTypeAnexo = MediaType.parseMediaType(modelo.getArquivoPreviewModelo().getContentType());

			InputStream inputStream = anexoStorageService.recuperar("previews/"  + modelo.getArquivoPreviewModelo().getCodigo());

			return ResponseEntity.ok()
					.header("Content-Disposition", "attachment; filename=" + modelo.getTitulo())
					.contentType(mediaTypeAnexo)
					.body(new InputStreamResource(inputStream));

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{codigoModelo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable UUID codigoModelo) {
		cadastroModelo.excluir(codigoModelo);
	}

}
