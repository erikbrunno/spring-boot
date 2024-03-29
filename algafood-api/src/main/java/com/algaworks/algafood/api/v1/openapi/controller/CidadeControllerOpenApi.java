package com.algaworks.algafood.api.v1.openapi.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.model.CidadeModel;
import com.algaworks.algafood.api.v1.model.input.CidadeInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Cidades")
public interface CidadeControllerOpenApi {

	@ApiOperation("Lista de cidades")
	public CollectionModel<CidadeModel> listar();

	@ApiResponses({ 
			@ApiResponse(code = 400, message = "ID da cidade inválido", response = Problem.class),
			@ApiResponse(code = 404, message = "Cidade não encontrada", response = Problem.class) })
	@ApiOperation("Busca uma cidade por ID")
	public CidadeModel buscar(@ApiParam(value = "ID de uma cidade", example = "1", required = true) Long cidadeId);

	@ApiOperation("Adiciona uma cidade por ID")
	public CidadeModel adicionar(
			@ApiParam(name = "corpo", value = "Representação de uma nova cidade") CidadeInput cidadeInput);

	@ApiOperation("Altera uma cidade por ID")
	public CidadeModel atualizar(@ApiParam(value = "ID de uma cidade", example = "1", required = true) Long cidadeId,
			@ApiParam(name = "corpo", value = "Representação de uma cidade com novas informações") CidadeInput cidadeInput);

	@ApiOperation("Exclui uma cidade por ID")
	public void remover(@ApiParam(value = "ID de uma cidade", example = "1", required = true) Long cozinhaId);
}
