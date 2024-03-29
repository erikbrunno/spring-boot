package com.algawors.algafood.auth.core;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityCore extends WebSecurityConfigurerAdapter {

	
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
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Injeta o bean AuthenticationManager
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		return super.userDetailsService();
//	}
}
