package com.algaworks.algafood.api.v1.model.mixin;

import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("cozinha")
public abstract class CozinhaMixin {
	
	@JsonProperty("titulo")
	private String nome;
	
	@JsonIgnore
	private List<Restaurante> restaurantes;

}
