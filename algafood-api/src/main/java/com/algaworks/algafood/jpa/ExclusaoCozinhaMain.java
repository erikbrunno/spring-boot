package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class ExclusaoCozinhaMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

		exibirRestaurantes(restauranteRepository.listar());
		
		Restaurante restaurante = new Restaurante();
		restaurante.setId(1L);
		restauranteRepository.remover(restaurante);
		
		exibirRestaurantes(restauranteRepository.listar());
		
	}
	
	public static void exibirRestaurantes(List<Restaurante> restaurantes) {
		
		for(Restaurante restaurante : restaurantes) {
			System.out.println(restaurante.getNome());
		}
	}

}
