package com.algaworks.algafood.api.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "permissoes")
@Getter
@Setter
public class PermissaoModel extends RepresentationModel<PermissaoModel>{
	
	@ApiModelProperty(value = "Id da permissao", example = "1")
	private Long id;
	
	@ApiModelProperty(value = "Nome da permissao", example = "Alterar")
	private String nome;
	
	@ApiModelProperty(value = "Descrição da permissao", example = "Pode alterar qualquer coisa")
	private String descricao;
}
