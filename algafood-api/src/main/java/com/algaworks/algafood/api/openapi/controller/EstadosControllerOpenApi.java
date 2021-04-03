package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import com.algaworks.algafood.api.model.EstadoModel;
import com.algaworks.algafood.api.model.input.EstadoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Estados")
public interface EstadosControllerOpenApi {

	@ApiOperation("Lista de Estados")
	public List<EstadoModel> listar();
	
	@ApiOperation("Busca um Estado por ID")
	public EstadoModel buscar(@ApiParam(value = "ID de um Estado", example = "1", required = true) Long estadoId);
	
	@ApiOperation("Adiciona um novo Estado")
	public EstadoModel adicionar(@ApiParam(name = "corpo", value = "Representação de um novo Estado") EstadoInput estadoInput);
	
	@ApiOperation("Atualiza um Estado por ID")
	public EstadoModel atualizar(
			@ApiParam(value = "ID de um Estado", example = "1", required = true) 
			Long estadoId, 
			
			@ApiParam(name = "corpo", value = "Representação de um Estado com novas informações")
			EstadoInput estadoInput);
	
	@ApiOperation("Remove um Estado por ID")
	public void remover(@ApiParam(value = "ID de um Estado", example = "1", required = true) Long estadoId);
	
}
