package com.algaworks.algafood.api.openapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.PedidoModel;
import com.algaworks.algafood.api.model.PedidoResumoModel;
import com.algaworks.algafood.api.model.input.PedidoInput;
import com.algaworks.algafood.domain.model.filter.PedidoFilter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Pedidos")
public interface PedidoControllerOpenApi {

	@ApiImplicitParams({
			@ApiImplicitParam(value = "Nomes das propriedades para filtrar na resposta, separados por vírgula", name = "campos", paramType = "query", type = "string") })
	@ApiOperation("Lista de pedidos")
	public Page<PedidoResumoModel> pesquisar(PedidoFilter filter, Pageable pageable);

	@ApiImplicitParams({
			@ApiImplicitParam(value = "Nomes das propriedades para filtrar na resposta, separados por vírgula", name = "campos", paramType = "query", type = "string") })
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "Codigo do pedido inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Codico do pedido não encontrado", response = Problem.class) })
	@ApiOperation("Busca um pedido pelo codigo")
	public PedidoModel buscar(@ApiParam(value="Codigo do pedido", example= "f9981ca4-5a5e-4da3-af04-933861df3e55") String codigoPedido);

	@ApiOperation(value="")
	public PedidoModel adicionar(@ApiParam(name = "corpo", value="Representação de um novo pedido") PedidoInput pedidoInput);
}
