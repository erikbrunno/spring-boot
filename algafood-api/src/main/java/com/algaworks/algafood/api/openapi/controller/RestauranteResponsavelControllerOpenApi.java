package com.algaworks.algafood.api.openapi.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.UsuarioModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Restaurantes")
public interface RestauranteResponsavelControllerOpenApi {

	@ApiResponses({
	     @ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)})
	@ApiOperation("Lista os responsaveis de um restaurante")
	public CollectionModel<UsuarioModel> listar(
			@ApiParam(value = "ID do restaurante", example = "1", required = true) 
			Long restauranteId);

	@ApiResponses({
        @ApiResponse(code = 204, message = "Associação realizada com sucesso"),
        @ApiResponse(code = 404, message = "Restaurante ou usuário não encontrado", 
            response = Problem.class)
    })
	@ApiOperation("Associa um responsável a um restaurante")
	public ResponseEntity<Void> associar(
			@ApiParam(value = "ID do restaurante", example = "1", required = true)
			Long restauranteId, 
			
			@ApiParam(value = "ID do responsavel", example = "1", required = true)
			Long responsavelId);

	@ApiResponses({
        @ApiResponse(code = 204, message = "Desassociação realizada com sucesso"),
        @ApiResponse(code = 404, message = "Restaurante ou usuário não encontrado", 
            response = Problem.class)})
	@ApiOperation("Desassocia um responsável a um restaurante")
	public ResponseEntity<Void> desassociar(
			@ApiParam(value = "ID do restaurante", example = "1", required = true)
			Long restauranteId, 
			
			@ApiParam(value = "ID do responsavel", example = "1", required = true)
			Long responsavelId);
	
}
