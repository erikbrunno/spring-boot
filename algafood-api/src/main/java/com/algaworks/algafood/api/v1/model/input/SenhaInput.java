package com.algaworks.algafood.api.v1.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SenhaInput {
    
	@ApiModelProperty(value = "Senha atual do usuário")
    @NotBlank
    private String senhaAtual;
    
	@ApiModelProperty(value = "Nova senha do usuário")
    @NotBlank
    private String novaSenha;
}  