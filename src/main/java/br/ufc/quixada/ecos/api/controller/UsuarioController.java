package br.ufc.quixada.ecos.api.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.quixada.ecos.api.assembler.ModeloModelAssembler;
import br.ufc.quixada.ecos.api.assembler.UsuarioInputDisassembler;
import br.ufc.quixada.ecos.api.assembler.UsuarioModelAssembler;
import br.ufc.quixada.ecos.api.model.ModeloModel;
import br.ufc.quixada.ecos.api.model.UsuarioModel;
import br.ufc.quixada.ecos.api.model.input.RecuperarSenhaInput;
import br.ufc.quixada.ecos.api.model.input.SenhaInput;
import br.ufc.quixada.ecos.api.model.input.UsuarioInput;
import br.ufc.quixada.ecos.core.security.EcosSecurity;
import br.ufc.quixada.ecos.domain.filter.ModeloFilter;
import br.ufc.quixada.ecos.domain.model.Modelo;
import br.ufc.quixada.ecos.domain.model.Usuario;
import br.ufc.quixada.ecos.domain.repository.ModeloRepository;
import br.ufc.quixada.ecos.domain.service.CadastroUsuarioService;
import br.ufc.quixada.ecos.infrastructure.repository.spec.ModeloSpecs;

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
    public UsuarioModel adicionar(@RequestBody @Valid UsuarioInput usuarioInput) {
        Usuario usuario = usuarioInputDisassembler.toDomainObject(usuarioInput);
        usuario = cadastroUsuario.salvar(usuario);

        return usuarioModelAssembler.toModel(usuario);
    }

    @PutMapping("/{codigoUsuario}")
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
}
