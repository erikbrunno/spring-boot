package com.algaworks.algafood.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CozinhaModel {

	private Long id;
	
	@JsonProperty("titulo")
	private String nome;
	
}
