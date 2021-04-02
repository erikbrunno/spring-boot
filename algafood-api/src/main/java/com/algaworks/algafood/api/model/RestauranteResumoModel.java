package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestauranteResumoModel {

	@ApiModelProperty(value = "ID do restaurante", example = "1")
    private Long id;
	
	@ApiModelProperty(value = "Nome do restaurante", example = "Restaurante Arretado de bom")
    private String nome;   
}   