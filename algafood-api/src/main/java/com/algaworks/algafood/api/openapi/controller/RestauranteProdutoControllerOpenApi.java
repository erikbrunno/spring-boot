package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.ProdutoModel;
import com.algaworks.algafood.api.model.input.ProdutoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Produtos")
public interface RestauranteProdutoControllerOpenApi {

	@ApiResponses({
		@ApiResponse(code = 400, message = "ID do restaurante inválido", response = Problem.class),
	    @ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)})
	@ApiOperation("Lista de produtos do restaurante")
	public List<ProdutoModel> listar(
			@ApiParam(value = "ID do restaurante", example = "1", required = true)
			Long restauranteId, 
			
			@ApiParam(value = "Indica se deve ou não incluir produtos inativos no resultado da listagem", 
            	example = "false", defaultValue = "false")
			boolean incluirInativos);
		
	@ApiResponses({
        @ApiResponse(code = 201, message = "Produto cadastrado"),
        @ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)})
	@ApiOperation("Adiciona um produto a um restaurante")
	public ProdutoModel adicionar(
			@ApiParam(value = "ID do restaurante", example = "1", required = true)
			Long restauranteId, 
			
			@ApiParam(name = "corpo", value = "Representação de um novo produto")
			ProdutoInput produtoInput);
	
	
	@ApiResponses({
        @ApiResponse(code = 400, message = "ID do restaurante ou produto inválido", response = Problem.class),
        @ApiResponse(code = 404, message = "Produto de restaurante não encontrado", response = Problem.class)})
	@ApiOperation("Busca um produto a um restaurante")
	public ProdutoModel buscar(
			@ApiParam(value = "ID do restaurante", example = "1", required = true)
			Long restauranteId, 
			
			@ApiParam(value = "ID do produto", example = "1", required = true)
			Long produtoId);
	
	@ApiResponses({
        @ApiResponse(code = 200, message = "Produto atualizado"),
        @ApiResponse(code = 404, message = "Produto de restaurante não encontrado", response = Problem.class)})
	@ApiOperation("Atualiza um produto a um restaurante")
	public ProdutoModel atualizar(
			@ApiParam(value = "ID do restaurante", example = "1", required = true)
			Long restauranteId,  
			
			@ApiParam(value = "ID do produto", example = "1", required = true)
			Long produtoId,
			
			@ApiParam(name = "corpo", value = "Representação de um produto com novas informacoes")
			ProdutoInput produtoInput);	
}
