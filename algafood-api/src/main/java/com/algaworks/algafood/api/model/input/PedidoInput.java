package com.algaworks.algafood.api.model.input;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PedidoInput {

	@ApiModelProperty(value = "Id do restaurante", example = "1")
    @Valid
    @NotNull
    private RestauranteIdInput restaurante;
    
	@ApiModelProperty(value = "Endereco de entrega do pedido", example = "Rua xpto, 123")
    @Valid
    @NotNull
    private EnderecoInput enderecoEntrega;
    
	@ApiModelProperty(value = "Forma de pagamento escolhida", example = "Cartão de credito")
    @Valid
    @NotNull
    private FormaPagamentoIdInput formaPagamento;
    
	@ApiModelProperty("Itens do pedido")
    @Valid
    @Size(min = 1)
    @NotNull
    private List<ItemPedidoInput> itens;
    
}    