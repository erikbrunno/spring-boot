package com.algaworks.algafood.api.v1.model.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.algaworks.algafood.core.validation.TaxaFrete;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestauranteInput {
	
	@ApiModelProperty(value = "Nome do restaurante", example="Restaurante cai-cai", required = true)
	@NotBlank
	private String nome;
	
	@ApiModelProperty(value = "Taxa frete do restaurante", example = "5")
	@TaxaFrete
	@NotNull
	private BigDecimal taxaFrete;
	
	@ApiModelProperty(value = "Cozinha do restaurante")
	@Valid
	@NotNull
	private CozinhaIdInput cozinha;
	
	@ApiModelProperty(value = "Endereco do restaurante")
	@Valid
	@NotNull
	private EnderecoInput endereco;

}
