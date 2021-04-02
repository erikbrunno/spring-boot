package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoModel {

	@ApiModelProperty(value = "Cep do endereco", example = "52120-000")
	private String cep;
	
	@ApiModelProperty(value = "logradouro", example = "Rua xpto")
	private String logradouro;
	
	@ApiModelProperty(value = "Número da rua", example = "10")
	private String numero;
	
	@ApiModelProperty(value = "complemento")
	private String complemento;
	
	@ApiModelProperty(value = "bairro", example = "bairro de perdição")
	private String bairro;
	
	@ApiModelProperty("Cidade")
	private CidadeResumoModel cidade;
	
}
