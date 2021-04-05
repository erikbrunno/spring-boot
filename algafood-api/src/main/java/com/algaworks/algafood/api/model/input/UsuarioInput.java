package com.algaworks.algafood.api.model.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {
	
	@ApiModelProperty(value = "Nome do usuário", example = "Erik Brunno", required = true)
	@NotBlank
	private String nome;
	
	@ApiModelProperty(value = "Email do usuário", example = "erik@mail.com", required = true)
	@NotBlank
	@Email
	private String email;
	
}
