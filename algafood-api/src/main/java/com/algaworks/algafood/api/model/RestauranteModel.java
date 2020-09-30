package com.algaworks.algafood.api.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteModel {

	private Long id;
	
	private String nome;
	
	private BigDecimal precoFrete;
	
	private CozinhaModel cozinha;
	
	private Boolean ativo;
	
	private Boolean aberto;
	
	private EnderecoModel endereco;
	
	/**
	 * Usei para exemplificar o funcionamento da estratégia de correspondência do model mapper
	 */
//	private BigDecimal frete;
//	private String nomeCozinha;
//	private String cozinhaNome;
//	private Long idCozinha;
	
}
