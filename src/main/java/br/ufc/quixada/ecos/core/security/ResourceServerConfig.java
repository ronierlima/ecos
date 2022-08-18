package br.ufc.quixada.ecos.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
				.antMatchers(HttpMethod.GET, "/modelos/**").permitAll()
				.antMatchers(HttpMethod.POST, "/usuarios").permitAll()
				.antMatchers(HttpMethod.PUT, "/usuarios/recuperar-senha").permitAll()
				.anyRequest().authenticated()
				.and()
				.csrf().disable()
				.cors().and()
				.oauth2ResourceServer().jwt();
	}

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
				"/v2/api-docs",
				"/webjars/**",
				"/configurations/**",
				"/swagger-resources/**");
	}
}
