package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrupoModel {
	
	@ApiModelProperty(value = "ID do grupo", example = "1")
	private Long id;
	
	@ApiModelProperty(value = "Nome do grupo", example = "Administrador")
	private String nome;

}
