package com.algaworks.algafood.api.v1.model.input;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CozinhaIdInput {
	
	@ApiModelProperty(value = "ID da cozinha", example = "1")
	@NotNull
	private Long id;
	
}
