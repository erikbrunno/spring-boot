package com.algaworks.algafood.api.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoModel {

	@ApiModelProperty(value = "ID do produto", example = "1")
	private Long id;
	
	@ApiModelProperty(value = "Nome do produto", example = "Caneta bic")
	private String nome;
	
	@ApiModelProperty(value = "Descrição do produto", example = "caneta azul - azul caneta")
	private String descricao;
	
	@ApiModelProperty(value = "Preço do produto", example = "1.50")
	private BigDecimal preco;
	
	@ApiModelProperty(example = "true")
	private Boolean ativo;
	
}
