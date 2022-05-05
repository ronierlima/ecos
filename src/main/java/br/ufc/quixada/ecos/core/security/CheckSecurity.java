package br.ufc.quixada.ecos.core.security;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@PreAuthorize("hasAuthority('ADMINISTRADOR')")
public @interface CheckSecurity {

	public @interface Denuncias {

		@PreAuthorize("hasAuthority('CONSULTAR_TODAS_DENUNCIAS') or " +
				"(hasAuthority('CONSULTAR_TODAS_DENUNCIAS_MUNICIPIO') and @oisolSecurityPermissions.isDenunciaDoMunicipioDaInstituicaoDoUsuario(#filtro.cidadeIdList))")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultarTodas {
		}

		@PostAuthorize("hasAuthority('CONSULTAR_TODAS_DENUNCIAS') or "
				+ "(hasAuthority('CONSULTAR_DETALHE_DENUNCIA') and (@oisolSecurityPermissions.isDenunciaEncaminhadaParaInstituicaoDoUsuario(returnObject) " +
				"or @oisolSecurityPermissions.isDenunciaDaInstituicaoDoUsuario(#codigoDenuncia))) " +
				"or (hasAuthority('CONSULTAR_TODAS_DENUNCIAS_MUNICIPIO') and @oisolSecurityPermissions.isDenunciaDoMunicipioDaInstituicaoDoUsuario(returnObject))")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultarDetalhe {
		}

		@PreAuthorize("hasAuthority('CONSULTAR_TODAS_DENUNCIAS') or "
				+ "(hasAuthority('CONSULTAR_DETALHE_DENUNCIA') and (@oisolSecurityPermissions.isDenunciaEncaminhadaParaInstituicaoDoUsuario(#codigoDenuncia)or @oisolSecurityPermissions.isDenunciaDaInstituicaoDoUsuario(#codigoDenuncia)))")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultarTodosDetalhes {
		}

		@PreAuthorize("hasAuthority('INCLUIR_DENUNCIA')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeCriar {
		}

		@PreAuthorize("hasAuthority('ALTERAR_TODAS_DENUNCIAS') or "
				+ "(hasAuthority('ALTERAR_DENUNCIAS_INSTITUICAO') and @oisolSecurityPermissions.isDenunciaDaInstituicaoDoUsuario(#codigoDenuncia))")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeAlterar {
		}

		@PreAuthorize("hasAuthority('ARQUIVAR_DENUNCIA')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeArquivar {
		}

		@PreAuthorize("hasAuthority('CONSULTAR_ESTATISTICAS')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultarEstatiscas {
		}

	}

	public @interface Encaminhamentos {

		@PreAuthorize("hasAuthority('CONSULTAR_TODOS_ENCAMINHAMENTOS')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultarTodos {
		}

		@PreAuthorize("hasAuthority('CONSULTAR_TODOS_ENCAMINHAMENTOS') or "
				+ "(hasAuthority('CONSULTAR_ENCAMINHAMENTOS_INSTITUICAO') and @oisolSecurityPermissions.isInstituicaoDoUsuario(#filtro.codigoInstituicao))")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultarPorInstituicao {
		}

		@PostAuthorize("hasAuthority('CONSULTAR_TODOS_ENCAMINHAMENTOS') or "
				+ "(hasAuthority('CONSULTAR_ENCAMINHAMENTOS_INSTITUICAO') and @oisolSecurityPermissions.isInstituicaoDoUsuario(returnObject.instituicao.codigo))")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultarDetalhe {
		}

		@PreAuthorize("hasAuthority('INCLUIR_ENCAMINHAMENTOS')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeCriar {
		}

		@PreAuthorize("hasAuthority('ALTERAR_TODOS_ENCAMINHAMENTOS') or "
				+ "(hasAuthority('ALTERAR_ENCAMINHAMENTO_INSTITUICAO') and @oisolSecurityPermissions.isEncaminhamentoDaInstituicaoDoUsuario(#codigoEncaminhamento))")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeAlterar {
		}

		@PreAuthorize("hasAuthority('ARQUIVAR_ENCAMINHAMENTO')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeArquivar {
		}

	}

	public @interface Instituicoes {

		@PreAuthorize("hasAuthority('GERENCIAR_INSTITUICOES')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeGerenciar {
		}

		@PreAuthorize("hasAuthority('ARQUIVAR_INSTITUICAO')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeArquivar {
		}

		@PreAuthorize("hasAuthority('GERENCIAR_INSTITUICOES') or hasAuthority('CONSULTAR_TODAS_INSTITUICOES') ")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultarTodas {
		}

	}

	public @interface Pessoas {

		@PreAuthorize("hasAuthority('CONSULTAR_PESSOAS')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultar {
		}

		@PreAuthorize("hasAuthority('CONSULTAR_PESSOAS') or "
				+ "(hasAuthority('CONSULTAR_DETALHE_DENUNCIA') and @oisolSecurityPermissions.isPessoaDeDenunciaEncaminhadaParaInstituicao(#codigoPessoa))")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultarDetalhe {
		}

		@PreAuthorize("hasAuthority('GERENCIAR_PESSOA')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeGerenciar {
		}

	}

	public @interface Usuarios {

		@PreAuthorize("hasAuthority('GERENCIAR_USUARIOS')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeGerenciar {
		}

		@PreAuthorize("hasAuthority('ALTERAR_SENHA') and @ecosSecurity.getCodigoUsuario() == #codigoUsuario")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeAlterarSenha {
		}

		@PreAuthorize("hasAuthority('GERENCIAR_USUARIOS') or @ecosSecurity.getCodigoUsuario() == #codigoUsuario")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeGerenciarTermo {
		}

	}

	public @interface CadastrosBasicos {

		@PreAuthorize("hasAuthority('GERENCIAR_CADASTROS_BASICOS')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeGerenciar {
		}

	}

	public @interface CadastrosVitais {

		@PreAuthorize("hasAuthority('ADMINISTRADOR')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeExcluir {
		}

	}
}
