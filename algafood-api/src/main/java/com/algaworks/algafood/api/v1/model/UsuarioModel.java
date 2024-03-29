package com.algaworks.algafood.api.v1.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "usuarios")
@Getter
@Setter
public class UsuarioModel extends RepresentationModel<UsuarioModel>{

	@ApiModelProperty(value = "ID do usuario", example = "1")
	private Long id;

	@ApiModelProperty(value = "Nome do usuário", example = "Erik Brunno")
	private String nome;

	@ApiModelProperty(value = "Email do usuário", example = "erik@mail.com")
	private String email;
}
