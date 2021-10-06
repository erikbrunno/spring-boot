
/*
 * Essa classe foi renomeada para ResourceServerConfig devido a aula 22.11 do curso, mantive ela comentada apenas
 * para nao perder a configuracao
 */

//package com.algaworks.algafood.core.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class WebSecurityCore extends WebSecurityConfigurerAdapter {
//
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("erik")
//				.password(passwordEncoder().encode("123"))
//				.roles("ADMIN")
//			.and()
//			.withUser("algafood")
//				.password(passwordEncoder().encode("123"))
//				.roles("ADMIN");
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		http.httpBasic()
//			.and()
////			.formLogin()
//			.authorizeRequests()
//				.antMatchers("/v1/cozinhas/**").permitAll()
//				.anyRequest().authenticated()
//			.and()
//				.sessionManagement()
//					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//			.and()
//				.csrf()
//					.disable();
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}
