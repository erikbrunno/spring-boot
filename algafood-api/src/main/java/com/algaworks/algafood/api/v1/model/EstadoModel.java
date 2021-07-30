package com.algaworks.algafood.api.v1.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "estados")
@Getter
@Setter
public class EstadoModel extends RepresentationModel<EstadoModel>{

	@ApiModelProperty(value = "ID  de um Estado", example = "1")
	private Long id;
			
	@ApiModelProperty(value = "Nome de um Estado", example = "Pernambuco")
	private String nome;
}
