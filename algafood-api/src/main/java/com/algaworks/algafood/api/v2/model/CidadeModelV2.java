package com.algaworks.algafood.api.v2.model;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeModelV2 extends RepresentationModel<CidadeModelV2> {
	
	private Long idCidade;
	
	private String nomeCidade;
	
	private Long idEstado;
	
	private String nomeEstado;
}
