package com.algaworks.algafood.api.openapi.controller;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.GrupoModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Usuários")
public interface UsuarioGrupoControllerOpenApi {

	@ApiResponses({
        @ApiResponse(code = 404, message = "Usuário não encontrado", response = Problem.class)
    })
	@ApiOperation("Lista os grupos pertencentes a um usuário")
	public CollectionModel<GrupoModel> lista(
			@ApiParam(value = "ID do usuário", example = "1", required = true)
			Long usuarioId);
	
	
	@ApiResponses({
		@ApiResponse(code = 204, message = "Desassociação realizada com sucesso"),
	    @ApiResponse(code = 404, message = "Usuário ou grupo não encontrado", 
	            response = Problem.class)})
	@ApiOperation("Desassocia um grupo do usuário")
	public void desassociar(
			@ApiParam(value = "ID do usuário", example = "1", required = true)
			Long usuarioId, 
			
			@ApiParam(value = "ID do grupo", example = "1", required = true)
			Long grupoId);
	
	@ApiResponses({
        @ApiResponse(code = 204, message = "Associação realizada com sucesso"),
        @ApiResponse(code = 404, message = "Usuário ou grupo não encontrado", 
            response = Problem.class)
    })	
	@ApiOperation("Associa um grupo do usuário")
	public void associar(
			@ApiParam(value = "ID do usuário", example = "1", required = true)
			Long usuarioId, 
			
			@ApiParam(value = "ID do grupo", example = "1", required = true)
			Long grupoId);
}
