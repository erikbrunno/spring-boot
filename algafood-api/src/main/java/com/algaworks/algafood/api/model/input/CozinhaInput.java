package com.algaworks.algafood.api.model.input;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CozinhaInput {

	@ApiModelProperty(example = "Brasileira", required = true)
	@NotBlank
	@JsonProperty("titulo")
	private String nome;

}
