package com.algaworks.algafood.api.v1.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "cidades")
@Getter
@Setter
public class CidadeResumoModel extends RepresentationModel<CidadeResumoModel>{
	
	@ApiModelProperty(value = "ID da cidade", example = "1")
	private Long id;
	
	@ApiModelProperty(value = "Nome da cidade", example = "Olinda")
	private String nome;
	
	@ApiModelProperty(value = "Estado", example = "Pernambuco")
	private String estado;	
	
}
