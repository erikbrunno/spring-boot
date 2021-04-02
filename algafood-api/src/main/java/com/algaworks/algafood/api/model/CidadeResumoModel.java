package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeResumoModel {
	
	@ApiModelProperty(value = "ID da cidade", example = "1")
	private Long id;
	
	@ApiModelProperty(value = "Nome da cidade", example = "Olinda")
	private String nome;
	
	@ApiModelProperty(value = "Estado", example = "Pernambuco")
	private String estado;	
	
}
