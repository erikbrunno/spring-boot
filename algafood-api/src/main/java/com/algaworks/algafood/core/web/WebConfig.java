package com.algaworks.algafood.core.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/*
	 * Habilita o CORS para qualquer origem
	 */
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedMethods("*");
//			.maxAge(30) Ativa o prefligth para 30 segundos
	}
}
