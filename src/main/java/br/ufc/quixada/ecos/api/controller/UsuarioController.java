package br.ufc.quixada.ecos.api.controller;

import br.ufc.quixada.ecos.api.assembler.ModeloModelAssembler;
import br.ufc.quixada.ecos.api.assembler.UsuarioInputDisassembler;
import br.ufc.quixada.ecos.api.assembler.UsuarioModelAssembler;
import br.ufc.quixada.ecos.api.model.ModeloModel;
import br.ufc.quixada.ecos.api.model.UsuarioModel;
import br.ufc.quixada.ecos.api.model.input.RecuperarSenhaInput;
import br.ufc.quixada.ecos.api.model.input.SenhaInput;
import br.ufc.quixada.ecos.api.model.input.UsuarioComSenhaInput;
import br.ufc.quixada.ecos.api.model.input.UsuarioInput;
import br.ufc.quixada.ecos.core.security.EcosSecurity;
import br.ufc.quixada.ecos.domain.exception.EntidadeNaoEncontradaException;
import br.ufc.quixada.ecos.domain.filter.ModeloFilter;
import br.ufc.quixada.ecos.domain.model.Anexo;
import br.ufc.quixada.ecos.domain.model.Modelo;
import br.ufc.quixada.ecos.domain.model.Usuario;
import br.ufc.quixada.ecos.domain.repository.ModeloRepository;
import br.ufc.quixada.ecos.domain.service.AnexoStorageService;
import br.ufc.quixada.ecos.domain.service.CadastroUsuarioService;
import br.ufc.quixada.ecos.infrastructure.repository.spec.ModeloSpecs;
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

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
    @Autowired
    private CadastroUsuarioService cadastroUsuario;

    @Autowired
    private UsuarioModelAssembler usuarioModelAssembler;

    @Autowired
    private UsuarioInputDisassembler usuarioInputDisassembler;

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private ModeloModelAssembler modeloModelAssembler;

    @Autowired
    private AnexoStorageService anexoStorageService;

    @Autowired
    private EcosSecurity security;

    @GetMapping
    public List<UsuarioModel> listar() {
        List<Usuario> todasUsuarios = cadastroUsuario.findAll();

        return usuarioModelAssembler.toCollectionModel(todasUsuarios);
    }

    @GetMapping("/{codigoUsuario}")
    public UsuarioModel buscar(@PathVariable UUID codigoUsuario) {
        Usuario usuario = cadastroUsuario.buscarOuFalhar(codigoUsuario);

        return usuarioModelAssembler.toModel(usuario);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModel adicionar(@RequestBody @Valid UsuarioComSenhaInput usuarioInput) {
        Usuario usuario = usuarioInputDisassembler.toDomainObject(usuarioInput);
        usuario = cadastroUsuario.salvar(usuario);

        return usuarioModelAssembler.toModel(usuario);
    }

    @PatchMapping("/{codigoUsuario}")
    public UsuarioModel atualizar(@PathVariable UUID codigoUsuario, @RequestBody @Valid UsuarioInput usuarioInput) {

        Usuario usuarioAtual = cadastroUsuario.buscarOuFalhar(codigoUsuario);
        usuarioInputDisassembler.copyToDomainObject(usuarioInput, usuarioAtual);
        usuarioAtual = cadastroUsuario.salvar(usuarioAtual);

        return usuarioModelAssembler.toModel(usuarioAtual);
    }

    @PutMapping("/{codigoUsuario}/senha")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarSenha(@PathVariable UUID codigoUsuario, @RequestBody @Valid SenhaInput senha) {
        cadastroUsuario.alterarSenha(codigoUsuario, senha.getSenhaAtual(), senha.getNovaSenha());
    }

    @PutMapping("/recuperar-senha")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void recuperarSenha(@RequestBody @Valid RecuperarSenhaInput input) {
        cadastroUsuario.recuperarSenha(input.getEmail());
    }

    @PutMapping("/{codigoUsuario}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedadeAtivo(@PathVariable UUID codigoUsuario, @RequestBody Boolean ativo) {
        cadastroUsuario.atualizarPropriedadeAtivo(codigoUsuario, ativo);
    }

    @GetMapping("/modelos")
    public Page<ModeloModel> pesquisar(ModeloFilter filtro, @PageableDefault(size = 10) Pageable pageable) {

        filtro.setCodigoUsuario(security.getCodigoUsuario());

        Page<Modelo> modelosPage = modeloRepository.findAll(ModeloSpecs.usandoFiltro(filtro), pageable);

        List<ModeloModel> modelosModel = modeloModelAssembler.toCollectionModel(modelosPage.getContent());

        PageImpl<ModeloModel> modelosModelPage = new PageImpl<>(modelosModel, pageable, modelosPage.getTotalElements());

        return modelosModelPage;
    }
    @RequestMapping(
            value = "/{codigoUsuario}/foto",
            method = RequestMethod.PUT,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void inserirFoto(@PathVariable UUID codigoUsuario,  @RequestPart(value = "file") MultipartFile fotoInput) throws IOException {

        Anexo fotoPerfil = new Anexo();

        fotoPerfil.setContentType(fotoInput.getContentType());
        fotoPerfil.setTamanho(fotoInput.getSize());

        cadastroUsuario.salvarFoto(codigoUsuario, fotoPerfil, fotoInput.getInputStream());
    }
    @GetMapping(value = "/{codigoUsuario}/foto")
    public ResponseEntity<InputStreamResource> servirFoto(@PathVariable UUID codigoUsuario) {
        try {
            Usuario usuario = cadastroUsuario.buscarOuFalhar(codigoUsuario);

            if(usuario.getFotoPerfil() == null)  return ResponseEntity.notFound().build();

            MediaType mediaTypeAnexo = MediaType.parseMediaType(usuario.getFotoPerfil().getContentType());

            InputStream inputStream = anexoStorageService.recuperar("perfil/"  + usuario.getCodigo());

            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=" + usuario.getNome())
                    .contentType(mediaTypeAnexo)
                    .body(new InputStreamResource(inputStream));

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
