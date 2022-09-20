package br.ufc.quixada.ecos.domain.service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.ufc.quixada.ecos.domain.model.Anexo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.ecos.domain.exception.EntidadeNaoEncontradaException;
import br.ufc.quixada.ecos.domain.exception.NegocioException;
import br.ufc.quixada.ecos.domain.model.Usuario;
import br.ufc.quixada.ecos.domain.repository.UsuarioRepository;
import br.ufc.quixada.ecos.domain.service.EnvioEmailService.Mensagem;
import br.ufc.quixada.ecos.infrastructure.util.GerarSenhaRandom;

@Service
public class CadastroUsuarioService {

    private static final String MSG_USUARIO_NAO_ENCONTRADO = "Não existe um cadastro de Usuário com código %s";

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

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

        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioExistente.isPresent() && !usuarioExistente.get().equals(usuario)) {
            throw new NegocioException(
                    String.format("Já existe um usuário cadastrado com o email %s", usuario.getEmail()));
        }

        boolean isUsuarioNovo = usuario.isNovo();

        if (isUsuarioNovo) {
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        }

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

//        if (isUsuarioNovo) {
//            envioEmailService.enviar(
//                    Mensagem.builder()
//                            .assunto("Cadastro de usuário")
//                            .corpo("usuario-cadastrado.html")
//                            .variavel("usuario", usuario)
//                            .variavel("senha", usuario.getSenha())
//                            .destinatario(usuario.getEmail())
//                            .build());
//        }

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

    public Usuario buscarOuFalhar(UUID codigoUsuario) {
        return usuarioRepository.findByCodigo(codigoUsuario).orElseThrow(
                () -> new EntidadeNaoEncontradaException(String.format(MSG_USUARIO_NAO_ENCONTRADO, codigoUsuario)));
    }

    public void atualizarPropriedadeAtivo(UUID codigoUsuario, Boolean ativo) {
        Usuario usuario = buscarOuFalhar(codigoUsuario);
        usuario.setAtivo(ativo);
        usuarioRepository.save(usuario);
    }

    public void recuperarSenha(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new EntidadeNaoEncontradaException(
                String.format("Não existe um cadastro de usuário com login %s", email)));

        if (!usuario.getEmail().equalsIgnoreCase(email)) {
            throw new NegocioException("E-mail informado não coincide com o cadastro do usuário.");
        }

        String senha = GerarSenhaRandom.gerarSenhaAleatoria();
        usuario.setSenha(passwordEncoder.encode(senha));
        usuarioRepository.save(usuario);
        System.out.println(senha);

    }

    @Transactional
    public void salvarFoto(UUID codigoUsuario, Anexo anexo, InputStream file) {

        Usuario usuario = buscarOuFalhar(codigoUsuario);

        Anexo anexoSalvo = cadastroAnexo.salvar(anexo);

        usuario.setFotoPerfil(anexoSalvo);


        AnexoStorageService.NovoAnexo novoAnexoModelo = AnexoStorageService.NovoAnexo.builder()
                .nomeArquivo(codigoUsuario.toString())
                .inputStream(file).build();

        anexoStorageService.armazenarCaminho(novoAnexoModelo, "perfil/"+usuario.getCodigo());

    }

}
