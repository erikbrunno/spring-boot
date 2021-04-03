package com.algaworks.algafood.api.openapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Pedidos")
public interface FluxoPedidoControllerOpenApi {

	@ApiOperation("Confirmação de pedido")
	public void confirmar(String codigoPedido);

	@ApiOperation("Cancelamento de pedido")
	public void cancelar(String codigoPedido);

	@ApiOperation("Entrega de pedido")
	public void entregar(String codigoPedido);
	
}
