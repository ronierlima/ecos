package br.ufc.quixada.ecos.api.controller;

import br.ufc.quixada.ecos.domain.model.Usuario;
import br.ufc.quixada.ecos.api.assembler.UsuarioInputDisassembler;
import br.ufc.quixada.ecos.api.assembler.UsuarioModelAssembler;
import br.ufc.quixada.ecos.api.model.UsuarioModel;
import br.ufc.quixada.ecos.api.model.input.RecuperarSenhaInput;
import br.ufc.quixada.ecos.api.model.input.SenhaInput;
import br.ufc.quixada.ecos.api.model.input.UsuarioComGrupoInput;
import br.ufc.quixada.ecos.api.model.input.UsuarioInput;
import br.ufc.quixada.ecos.core.security.EcosSecurity;
import br.ufc.quixada.ecos.domain.service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    private EcosSecurity ecosSecurity;


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
    public UsuarioModel adicionar(@RequestBody @Valid UsuarioComGrupoInput usuarioInput) {
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
        cadastroUsuario.recuperarSenha(input.getLogin(), input.getEmail());
    }

    @PutMapping("/{codigoUsuario}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedadeAtivo(@PathVariable UUID codigoUsuario, @RequestBody Boolean ativo) {
        cadastroUsuario.atualizarPropriedadeAtivo(codigoUsuario, ativo);
    }
}
