package com.algaworks.algafood.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFilter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

//@JsonFilter("pedidoFilter")
@Setter
@Getter
public class PedidoResumoModel {

	@ApiModelProperty(value = "Codigo do pedido", example = "1")
    private String codigo;
	
	@ApiModelProperty(value = "subtotal do pedido", example = "10")
    private BigDecimal subtotal;
	
	@ApiModelProperty(value = "Taxa frete do pedido", example = "5")
    private BigDecimal taxaFrete;
	
	@ApiModelProperty(value="valor total do pedido", example = "15")
    private BigDecimal valorTotal;
	
	@ApiModelProperty(value="statudo do pedido", example = "CONFIRMADO")
    private String status;
	
	@ApiModelProperty(value = "Data de criação do pedido")
    private OffsetDateTime dataCriacao;
	
	@ApiModelProperty(value = "Restaurante onde foi feito pedido", example="Restaurante arretado")
    private RestauranteResumoModel restaurante;
	
	@ApiModelProperty(value = "Cliente que realizou o pedido", example="Erik Brunno")
    private UsuarioModel cliente;
}  