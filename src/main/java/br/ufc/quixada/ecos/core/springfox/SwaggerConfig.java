package br.ufc.quixada.ecos.core.springfox;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;

import br.ufc.quixada.ecos.core.springfox.model.PageableModelSwagger;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket productApi(){

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.ufc.quixada.ecos.api"))
				.paths(PathSelectors.any())
				.build()
				.directModelSubstitute(Pageable.class, PageableModelSwagger.class)
				.securitySchemes(Arrays.asList(securityScheme()))
				.securityContexts(Arrays.asList(securityContext()))
				.apiInfo(metaInfo());
	}


	private ApiInfo metaInfo() {
		return new ApiInfoBuilder()
				.title("Oi Sol API local")
				.description("API do Observatório de Indicadores Sociais - Oi Sol")
				.version("1")
				.build();

	}

	private SecurityScheme securityScheme() {
		return new OAuthBuilder()
				.name("OiSol")
				.grantTypes(grantTypes())
				.scopes(scopes())
				.build();
	}

	private SecurityContext securityContext() {
		var securityReference = SecurityReference.builder()
				.reference("OiSol")
				.scopes(scopes().toArray(new AuthorizationScope[0]))
				.build();

		return SecurityContext.builder()
				.securityReferences(Arrays.asList(securityReference))
				.build();
	}

	private List<GrantType> grantTypes() {
		return Arrays.asList(new ResourceOwnerPasswordCredentialsGrant("/ecos-api/oauth/token"));
	}

	private List<AuthorizationScope> scopes() {
		return Arrays.asList(new AuthorizationScope("READ", "Acesso de leitura"),
				new AuthorizationScope("WRITE", "Acesso de escrita"));
	}

}