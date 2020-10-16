package com.algaworks.algafood.api.model;

import java.math.BigDecimal;

import com.algaworks.algafood.api.model.view.RestauranteView;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteModel {

	@JsonView({RestauranteView.Resumo.class,  RestauranteView.ApenasNome.class})
	private Long id;
	
	@JsonView({RestauranteView.Resumo.class, RestauranteView.ApenasNome.class})
	private String nome;
	
	@JsonView(RestauranteView.Resumo.class)
	private BigDecimal precoFrete;
	
	@JsonView(RestauranteView.Resumo.class)
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
