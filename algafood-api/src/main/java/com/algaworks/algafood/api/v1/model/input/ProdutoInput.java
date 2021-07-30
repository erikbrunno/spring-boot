package com.algaworks.algafood.api.v1.model.input;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoInput {

	@ApiModelProperty(value = "Nome do produto", example = "Caneta bic", required = true)
	@NotBlank
	private String nome;

	@ApiModelProperty(value = "Descrição do produto", example = "azul caneta", required = true)
	@NotBlank
	private String descricao;

	@ApiModelProperty(value = "Preco do produto", example = "2")
	@NotNull
	@PositiveOrZero
	private BigDecimal preco;

	@ApiModelProperty(example = "true")
	@NotNull
	private Boolean ativo;
}
