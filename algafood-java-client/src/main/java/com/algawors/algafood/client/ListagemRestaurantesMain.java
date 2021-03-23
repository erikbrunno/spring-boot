package com.algawors.algafood.client;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.algawors.algafood.client.api.ClientApiException;
import com.algawors.algafood.client.api.RestauranteClient;
import com.algawors.algafood.client.model.RestauranteResumoModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListagemRestaurantesMain {

	public static void main(String[] args) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			RestauranteClient restauranteClient = new RestauranteClient(
					restTemplate, "http://localhost:8080");
			
			List<RestauranteResumoModel> restaurantes = restauranteClient.listar();
			restaurantes.stream().forEach(r -> log.info(r.getNome()));
		} catch (ClientApiException e) {
			if (e.getProblem() != null) {
				log.info(e.getProblem().getUserMessage());
			} else {
				log.info("Erro desconhecido");
			}
		}
		
	}
	
}
