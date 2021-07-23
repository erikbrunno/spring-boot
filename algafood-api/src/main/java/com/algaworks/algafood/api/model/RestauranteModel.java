package com.algaworks.algafood.api.model;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.algaworks.algafood.api.model.view.RestauranteView;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "restaurantes")
@Getter
@Setter
public class RestauranteModel extends RepresentationModel<RestauranteModel> {

	@ApiModelProperty(value = "ID  do restaurante", example = "1")
	@JsonView({RestauranteView.Resumo.class,  RestauranteView.ApenasNome.class})
	private Long id;
	
	@ApiModelProperty(value = "Nome  do restaurante", example = "Restaurante bom demais")
	@JsonView({RestauranteView.Resumo.class, RestauranteView.ApenasNome.class})
	private String nome;
	
	@ApiModelProperty(value = "Preço frete  do restaurante", example = "10")
	@JsonView(RestauranteView.Resumo.class)
	private BigDecimal precoFrete;
	
	@ApiModelProperty(value = "Cozinha do restaurante")
	@JsonView(RestauranteView.Resumo.class)
	private CozinhaModel cozinha;
	
	@ApiModelProperty(example = "true")
	private Boolean ativo;
	
	@ApiModelProperty(example = "true")
	private Boolean aberto;
	
	@ApiModelProperty(value = "Enderedo do restaurante")
	private EnderecoModel endereco;
	
	/**
	 * Usei para exemplificar o funcionamento da estratégia de correspondência do model mapper
	 */
//	private BigDecimal frete;
//	private String nomeCozinha;
//	private String cozinhaNome;
//	private Long idCozinha;
	
}
