package com.algaworks.algafood.api.v1.openapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.model.RestauranteModel;
import com.algaworks.algafood.api.v1.model.input.RestauranteInput;

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
		@ApiResponse(code = 400, message = "ID do restaurante inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Restaurante não encontrada", response = Problem.class) })
	@ApiOperation(value = "Busca um restaurante por ID")
	public RestauranteModel buscar(@ApiParam(value = "ID do restaurante", example = "1", required = true) Long restauranteId);
	
	@ApiResponses({
        @ApiResponse(code = 201, message = "Restaurante cadastrado")})
	@ApiOperation("Adiciona um novo restaurante")
	public RestauranteModel adicionar(
			@ApiParam(name = "corpo", value = "Representar de um novo restaurante") RestauranteInput restauranteInput);
	
	 @ApiResponses({
	        @ApiResponse(code = 200, message = "Restaurante atualizado"),
	        @ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)})
	@ApiOperation("Altera um restaurante")
	public RestauranteModel atualizar(
			@ApiParam(value = "ID de um restaurante", example = "1", required = true)
			Long restauranteId, 
			
			@ApiParam(name = "corpo", value = "Representação de um restaurante com novas informacoes")
			RestauranteInput restauranteInput);
	
	 @ApiResponses({
	        @ApiResponse(code = 204, message = "Restaurante ativado com sucesso"),
	        @ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)})
	@ApiOperation("Ativa um restaurante por ID")
	public ResponseEntity<Void> ativar(@ApiParam(value="ID de um restaurante", example = "1", required = true) Long restauranteId);
	
	 @ApiResponses({
	        @ApiResponse(code = 204, message = "Restaurante inativado com sucesso"),
	        @ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)})
	@ApiOperation("Inativa um restaurante por ID")
	public ResponseEntity<Void> inativar(@ApiParam(value="ID de um restaurante", example = "1", required = true) Long restauranteId);
	
	@ApiResponses({
	        @ApiResponse(code = 204, message = "Restaurantes ativados com sucesso")})
	@ApiOperation("Ativa varios restaurante passando os IDs")
	public void ativarEmLote(
			@ApiParam(name = "corpo", value = "IDs de restaurantes", required = true)
			List<Long> restaurantesIds);
	
	@ApiResponses({
	        @ApiResponse(code = 204, message = "Restaurantes ativados com sucesso")})
	@ApiOperation("Inativa varios restaurante passandos os IDs")
	public void inativarEmLote(
			@ApiParam(name = "corpo", value = "IDs de restaurantes", required = true)
			List<Long> restaurantesIds);
	
	@ApiResponses({
	        @ApiResponse(code = 204, message = "Restaurante aberto com sucesso"),
	        @ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)})
	@ApiOperation("Abre um restaurante por id")
	public ResponseEntity<Void> abrir(@ApiParam(value="ID de um restaurante", example = "1", required = true) Long restauranteId);
	
	@ApiResponses({
	        @ApiResponse(code = 204, message = "Restaurante fechado com sucesso"),
	        @ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)})
	@ApiOperation("Fecha um restaurante por id")
	public ResponseEntity<Void> fechar(@ApiParam(value="ID de um restaurante", example = "1", required = true) Long restauranteId);

}
