package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissaoModel {
	
	@ApiModelProperty(value = "Id da permissao", example = "1")
	private Long id;
	
	@ApiModelProperty(value = "Nome da permissao", example = "Alterar")
	private String nome;
	
	@ApiModelProperty(value = "Descrição da permissao", example = "Pode alterar qualquer coisa")
	private String descricao;
}
