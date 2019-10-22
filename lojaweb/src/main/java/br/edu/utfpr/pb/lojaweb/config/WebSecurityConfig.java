package br.edu.utfpr.pb.lojaweb.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.edu.utfpr.pb.lojaweb.service.impl.UsuarioServiceImpl;


@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioServiceImpl);
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		//http.authorizeRequests().anyRequest().permitAll();
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	
		web.ignoring()
		.antMatchers("/css/**")
		.antMatchers("/js/**")
		.antMatchers("/images/**")
		.antMatchers("/assets/**")
		.antMatchers("/vendors/**")
		.antMatchers("/webjars/**");
	}
	
	
}
