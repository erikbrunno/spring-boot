package com.algaworks.algafood.api.v2.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeInputV2 {

	@ApiModelProperty(example = "Recife", required = true)
	@NotBlank
	private String nomeCidade;

	private Long idEstado;
}
