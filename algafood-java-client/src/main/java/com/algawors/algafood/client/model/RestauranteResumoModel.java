package com.algawors.algafood.client.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteResumoModel {

	private Long id;
	private String nome;
	private BigDecimal precoFrete;
	private CozinhaModel cozinha;
	
}
