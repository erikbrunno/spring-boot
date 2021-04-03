package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.EstadoModel;
import com.algaworks.algafood.api.model.input.EstadoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Estados")
public interface EstadosControllerOpenApi {

	@ApiOperation("Lista de Estados")
	public List<EstadoModel> listar();
	
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "ID da cidade inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Cidade não encontrada", response = Problem.class) })
	@ApiOperation("Busca um Estado por ID")
	public EstadoModel buscar(@ApiParam(value = "ID de um Estado", example = "1", required = true) Long estadoId);
	
	@ApiResponses({
	    @ApiResponse(code = 201, message = "Estado cadastrado")})
	@ApiOperation("Adiciona um novo Estado")
	public EstadoModel adicionar(@ApiParam(name = "corpo", value = "Representação de um novo Estado") EstadoInput estadoInput);
	
	@ApiResponses({
	    @ApiResponse(code = 200, message = "Estado atualizado"),
	    @ApiResponse(code = 404, message = "Estado não encontrado", response = Problem.class)})
	@ApiOperation("Atualiza um Estado por ID")
	public EstadoModel atualizar(
			@ApiParam(value = "ID de um Estado", example = "1", required = true) 
			Long estadoId, 
			
			@ApiParam(name = "corpo", value = "Representação de um Estado com novas informações")
			EstadoInput estadoInput);
	
	@ApiResponses({ 
		@ApiResponse(code = 204, message = "Estado excluído"),
		@ApiResponse(code = 404, message = "Estado não encontrado", response = Problem.class) })
	@ApiOperation("Remove um Estado por ID")
	public void remover(@ApiParam(value = "ID de um Estado", example = "1", required = true) Long estadoId);
	
}
