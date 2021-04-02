package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioModel {

	@ApiModelProperty(value = "ID do usuario", example = "1")
	private Long id;

	@ApiModelProperty(value = "Nome do usuário", example = "Erik Brunno")
	private String nome;

	@ApiModelProperty(value = "Email do usuário", example = "erik@mail.com")
	private String email;
}
