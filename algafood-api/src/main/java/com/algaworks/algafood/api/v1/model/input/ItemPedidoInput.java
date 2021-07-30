package com.algaworks.algafood.api.v1.model.input;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemPedidoInput {

	@ApiModelProperty(value = "ID do produto", example = "1")
    @NotNull
    private Long produtoId;
    
	@ApiModelProperty(value = "Quantidade do produto", example = "2")
    @NotNull
    @PositiveOrZero
    private Integer quantidade;
    
    private String observacao;   
}  