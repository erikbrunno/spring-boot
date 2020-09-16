package com.algaworks.algafood.api.model.input;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CozinhaInput {

	@NotBlank
	@JsonProperty("titulo")
	private String nome;

}
