package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.GrupoModel;
import com.algaworks.algafood.api.model.input.GrupoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Grupos")
public interface GrupoControllerOpenApi {

	@ApiOperation("Lista de grupos")
	public List<GrupoModel> listar();	

	@ApiResponses({ 
		@ApiResponse(code = 400, message = "ID do grupo inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Grupo não encontrado", response = Problem.class) })
	@ApiOperation("Busca grupo por ID")
	public GrupoModel buscar(@ApiParam(value = "ID de um grupo", example = "1") Long grupoId);	

	@ApiOperation("Adiciona um novo grupo")
	public GrupoModel adicionar(
			@ApiParam(name = "corpo", value = "Representação de um novo grupo")
			GrupoInput grupoInput);
	
	@ApiOperation("Altera um grupo por ID")
	public GrupoModel atualizar(
			@ApiParam(value = "ID de um grupo", example = "1")
			Long grupoId, 
			
			@ApiParam(name = "corpo", value = "Representação de um grupo com novas informações")
			GrupoInput grupoInput);	
	
	@ApiOperation("Remove o grupo por ID")
	public void remover(@ApiParam(value = "ID de um grupo", example = "1") Long grupoId);
	
}
