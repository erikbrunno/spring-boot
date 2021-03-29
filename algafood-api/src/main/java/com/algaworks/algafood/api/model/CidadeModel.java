package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

//@ApiModel(value = "CidadeModelAlterada", description = "Representa uma cidade")
@Getter
@Setter
public class CidadeModel {
	
//	@ApiModelProperty(value = "ID da cidade", example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Recife")
	private String nome;
	
	@ApiModelProperty(example = "Pernambuco")
	private EstadoModel estado;	
	
}
