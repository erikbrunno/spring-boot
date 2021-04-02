package com.algaworks.algafood.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoInput {

	@ApiModelProperty(value = "Cep do endereco", example = "52120-000", required = true)
	@NotBlank
	private String cep;

	@ApiModelProperty(value = "logradouro", example = "Rua xpto", required = true)
	@NotBlank
	private String logradouro;

	@ApiModelProperty(value = "Número da rua", example = "123", required = true)
	@NotBlank
	private String numero;

	@ApiModelProperty(value = "complemento")
	private String complemento;

	@ApiModelProperty(value = "bairro", example = "bairro de perdição", required = true)
	@NotBlank
	private String bairro;

	@ApiModelProperty("Cidade")
	@NotNull
	@Valid
	private CidadeIdInput cidade;

}
