package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.RestauranteModel;
import com.algaworks.algafood.api.model.input.RestauranteInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Restaurantes")
public interface RestauranteControllerOpenApi {
	
	@ApiOperation(value = "Lista de restaurantes")
	@ApiImplicitParams({
		@ApiImplicitParam(value = "Nome da projeção de pedidos - resumo de restaurante", 
				name = "projecao", allowableValues = "apenas-nome, resumo", paramType = "query", type = "string")
	})
	public List<RestauranteModel> listar();
	
	@ApiOperation(value = "Lista de restaurantes", hidden = true)
	public List<RestauranteModel> listarResumo();
	
	@ApiOperation(value = "Lista de restaurantes", hidden = true)
	public List<RestauranteModel> listarApenasNome();
	
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "ID da cidade inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Cidade não encontrada", response = Problem.class) })
	@ApiOperation(value = "Busca um restaurante por ID")
	public RestauranteModel buscar(@ApiParam(value = "ID do restaurante", example = "1", required = true) Long restauranteId);
	
	@ApiOperation("Adiciona um novo restaurante")
	public RestauranteModel adicionar(
			@ApiParam(name = "corpo", value = "Representar de um novo restaurante") RestauranteInput restauranteInput);
	
	@ApiOperation("Altera um restaurante")
	public RestauranteModel atualizar(
			@ApiParam(value = "ID de um restaurante", example = "1", required = true)
			Long restauranteId, 
			
			@ApiParam(name = "corpo", value = "Representação de um restaurante com novas informacoes")
			RestauranteInput restauranteInput);
	
	@ApiOperation("Ativa um restaurante por ID")
	public void ativar(@ApiParam(value="ID de um restaurante", example = "1") Long restauranteId);
	
	@ApiOperation("Inativa um restaurante por ID")
	public void inativar(@ApiParam(value="ID de um restaurante", example = "1") Long restauranteId);
	
	@ApiOperation("Ativa varios restaurante passando os IDs")
	public void ativarEmLote(List<Long> restaurantesIds);
	
	@ApiOperation("Inativa varios restaurante passandos os IDs")
	public void inativarEmLote(List<Long> restaurantesIds);
	
	@ApiOperation("Abre um restaurante por id")
	public void abrir(@ApiParam(value="ID de um restaurante", example = "1") Long restauranteId);
	
	@ApiOperation("Fecha um restaurante por id")
	public void fechar(@ApiParam(value="ID de um restaurante", example = "1") Long restauranteId);

}
