package com.algaworks.algafood.api.v1.model.input;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestauranteIdInput {
	
	@ApiModelProperty(value = "ID do restaurante", example = "1")
	@NotNull
	private Long id;

}
