package br.gov.ce.sps.oisol.domain.service;

import br.gov.ce.sps.oisol.domain.exception.EntidadeNaoEncontradaException;
import br.gov.ce.sps.oisol.domain.exception.NegocioException;
import br.gov.ce.sps.oisol.domain.model.Anexo;
import br.gov.ce.sps.oisol.domain.model.Grupo;
import br.gov.ce.sps.oisol.domain.model.Usuario;
import br.gov.ce.sps.oisol.domain.repository.UsuarioRepository;
import br.gov.ce.sps.oisol.domain.service.EnvioEmailService.Mensagem;
import br.gov.ce.sps.oisol.infrastructure.util.GerarSenhaRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CadastroUsuarioService {

    private static final String MSG_USUARIO_NAO_ENCONTRADO = "Não existe um cadastro de Usuário com código %s";

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CadastroGrupoService cadastroGrupo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EnvioEmailService envioEmailService;

    @Autowired
    private CadastroAnexoService cadastroAnexo;

    @Autowired
    private AnexoStorageService anexoStorageService;

    public List<Usuario> findAll() {

        return usuarioRepository.findAll(Sort.by("ativo").descending().and(Sort.by("nome")));
    }

    @Transactional
    public Usuario salvar(Usuario usuario) {
        usuarioRepository.detach(usuario);

        Optional<Usuario> usuarioExistente = usuarioRepository.findByLogin(usuario.getLogin());

        if (usuarioExistente.isPresent() && !usuarioExistente.get().equals(usuario)) {
            throw new NegocioException(
                    String.format("Já existe um usuário cadastrado com o login %s", usuario.getLogin()));
        }




        boolean isUsuarioNovo = usuario.isNovo();
        String senhaAleatoria = null;

        if (isUsuarioNovo) {
            if (usuario.getGrupos() != null) {
                usuario.setGrupos(usuario.getGrupos().stream()
                        .map(g -> cadastroGrupo.buscarOuFalhar(g.getCodigo()))
                        .collect(Collectors.toSet()));
            }
            senhaAleatoria = GerarSenhaRandom.gerarSenhaAleatoria();
            usuario.setSenha(passwordEncoder.encode(senhaAleatoria));
        }

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        if (isUsuarioNovo) {
            envioEmailService.enviar(
                    Mensagem.builder()
                            .assunto("Cadastro de usuário")
                            .corpo("usuario-cadastrado.html")
                            .variavel("usuario", usuario)
                            .variavel("senha", senhaAleatoria)
                            .destinatario(usuario.getEmail())
                            .build());
        }

        return usuarioSalvo;
    }

    @Transactional
    public void alterarSenha(UUID codigoUsuario, String senhaAtual, String novaSenha) {
        Usuario usuario = buscarOuFalhar(codigoUsuario);

        if (!passwordEncoder.matches(senhaAtual, usuario.getSenha())) {
            throw new NegocioException("Senha atual informada não coincide com a senha do usuário.");
        }

        usuario.setSenha(passwordEncoder.encode(novaSenha));
    }

    @Transactional
    public void desassociarGrupo(UUID codigoUsuario, UUID codigoGrupo) {
        Usuario usuario = buscarOuFalhar(codigoUsuario);
        Grupo grupo = cadastroGrupo.buscarOuFalhar(codigoGrupo);

        usuario.removerGrupo(grupo);
    }

    @Transactional
    public void associarGrupo(UUID codigoUsuario, UUID codigoGrupo) {
        Usuario usuario = buscarOuFalhar(codigoUsuario);
        Grupo grupo = cadastroGrupo.buscarOuFalhar(codigoGrupo);

        usuario.adicionarGrupo(grupo);
    }

    public Usuario buscarOuFalhar(UUID codigoUsuario) {
        return usuarioRepository.findByCodigo(codigoUsuario).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format(MSG_USUARIO_NAO_ENCONTRADO, codigoUsuario)));
    }

    public void atualizarPropriedadeAtivo(UUID codigoUsuario, Boolean ativo) {
        Usuario usuario = buscarOuFalhar(codigoUsuario);
        usuario.setAtivo(ativo);
        usuarioRepository.save(usuario);
    }

    public void recuperarSenha(String login, String email) {
        Usuario usuario = usuarioRepository.findByLogin(login).orElseThrow(() -> new EntidadeNaoEncontradaException(
                String.format("Não existe um cadastro de usuário com login %s", login)));

        if (!usuario.getEmail().equalsIgnoreCase(email)) {
            throw new NegocioException("E-mail informado não coincide com o cadastro do usuário.");
        }

        String senha = GerarSenhaRandom.gerarSenhaAleatoria();
        usuario.setSenha(passwordEncoder.encode(senha));
        usuarioRepository.save(usuario);
        System.out.println(senha);

    }

}
