package com.algaworks.algafood.api.controller;

import static com.algaworks.algafood.infraestructure.repository.spec.RestauranteSpecs.comFreteGratis;
import static com.algaworks.algafood.infraestructure.repository.spec.RestauranteSpecs.comNomeSemelhante;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@GetMapping("/restaurantes/por-nome-e-frete")
	public List<Restaurante> restaurantePorNomeFrete(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		return restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
	}
	
	@GetMapping("/restaurantes/com-frete-gratis")
	public List<Restaurante> restauranteComFreteGratis(String nome) {
		
		return restauranteRepository.findComFreteGratis(nome);
	}
	

}
