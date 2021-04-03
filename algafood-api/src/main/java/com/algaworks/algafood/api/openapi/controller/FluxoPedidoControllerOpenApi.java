package com.algaworks.algafood.api.openapi.controller;

import com.algaworks.algafood.api.exceptionhandler.Problem;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Pedidos")
public interface FluxoPedidoControllerOpenApi {

	@ApiResponses({
	    @ApiResponse(code = 204, message = "Pedido confirmado com sucesso"),
	    @ApiResponse(code = 404, message = "Pedido não encontrado", response = Problem.class)})
	@ApiOperation("Confirmação de pedido")
	public void confirmar(
			@ApiParam(value = "Codigo do pedido", example = "f9981ca4-5a5e-4da3-af04-933861df3e55", required = true)
			String codigoPedido);

	@ApiResponses({
        @ApiResponse(code = 204, message = "Pedido cancelado com sucesso"),
        @ApiResponse(code = 404, message = "Pedido não encontrado", response = Problem.class)})
	@ApiOperation("Cancelamento de pedido")
	public void cancelar(
			@ApiParam(value = "Codigo do pedido", example = "f9981ca4-5a5e-4da3-af04-933861df3e55", required = true)
			String codigoPedido);

	@ApiResponses({
        @ApiResponse(code = 204, message = "Entrega de pedido registrada com sucesso"),
        @ApiResponse(code = 404, message = "Pedido não encontrado", response = Problem.class)})
	@ApiOperation("Entrega de pedido")
	public void entregar(
			@ApiParam(value = "Codigo do pedido", example = "f9981ca4-5a5e-4da3-af04-933861df3e55", required = true)
			String codigoPedido);
	
}
