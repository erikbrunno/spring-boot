package com.algaworks.algafood.api.openapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.CozinhaModel;
import com.algaworks.algafood.api.model.CozinhasXmlWrapper;
import com.algaworks.algafood.api.model.input.CozinhaInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Cozinhas")
public interface CozinhaControllerOpenApi {

	@ApiOperation("Lista de cozinhas")
	public Page<CozinhaModel> pesquisar(Pageable pageable);
	
	public CozinhasXmlWrapper listarXml();
	
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "ID da cidade inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Cidade não encontrada", response = Problem.class) })
	@ApiOperation("Busca uma cozinha por ID")
	public CozinhaModel buscar(@ApiParam(value = "ID de uma cozinha", example = "1", required = true) Long cozinhaId);
	
	@ApiOperation("Adiciona uma cozinha")
	public CozinhaModel adicionar(
			@ApiParam(name = "corpo", value = "Representação de uma nova cozinha") 
			CozinhaInput cozinhaInput);
	
	@ApiOperation("Atualiza uma cozinha por ID")
	public CozinhaModel atualizar(
			@ApiParam(value = "ID de uma cozinha", example = "1", required = true) 
			Long cozinhaId,
			
			@ApiParam(name = "corpo", value = "Representação de uma cozinha com novas informações")
			CozinhaInput cozinhaInput);	

	@ApiOperation(value = "Remove uma cozinha por ID")
	public void remover(@ApiParam(value = "ID de uma cozinha", example = "1") Long cozinhaId);
	
}
