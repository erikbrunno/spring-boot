package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoModel {

	@ApiModelProperty(value = "ID  de um Estado", example = "1")
	private Long id;
			
	@ApiModelProperty(value = "Nome de um Estado", example = "Pernambuco")
	private String nome;
}
