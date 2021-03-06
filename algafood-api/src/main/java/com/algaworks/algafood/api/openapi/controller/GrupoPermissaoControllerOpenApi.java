package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.PermissaoModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Grupos")
public interface GrupoPermissaoControllerOpenApi {

	@ApiResponses({ 
		@ApiResponse(code = 400, message = "ID do grupo inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Grupo não encontrado", response = Problem.class) })
	@ApiOperation("Lista permissoes do grupo")
	public List<PermissaoModel> listar(@ApiParam(value = "ID do grupo", example = "1") Long grupoId);

	@ApiResponses({
		@ApiResponse(code = 204, message = "A permissao foi desassociada do grupo")
	})
	@ApiOperation("Desassocia uma permissao a um grupo")
	public void desassociar(
			@ApiParam(value = "ID do grupo", example = "1")
			Long grupoId, 
			
			@ApiParam(value = "ID da permissao", example = "1")
			Long permissaoId);

	@ApiResponses({
		@ApiResponse(code = 204, message = "A permissao foi associada do grupo")
	})
	@ApiOperation("Associa uma permissao a um grupo")
	public void associar(
			@ApiParam(value = "ID do grupo", example = "1")
			Long grupoId, 
			
			@ApiParam(value = "ID da permissao", example = "1")
			Long permissaoId);

}
