package com.algaworks.algafood.api.v2.openapi.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.model.CozinhasXmlWrapper;
import com.algaworks.algafood.api.v2.model.CozinhaModelV2;
import com.algaworks.algafood.api.v2.model.input.CozinhaInputV2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Cozinhas")
public interface CozinhaControllerOpenApiV2 {

	@ApiOperation("Lista de cozinhas")
	public PagedModel<CozinhaModelV2> pesquisar(Pageable pageable);
	
	public CozinhasXmlWrapper listarXml();
	
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "ID da cidade inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Cidade não encontrada", response = Problem.class) })
	@ApiOperation("Busca uma cozinha por ID")
	public CozinhaModelV2 buscar(@ApiParam(value = "ID de uma cozinha", example = "1", required = true) Long cozinhaId);
	
	@ApiOperation("Adiciona uma cozinha")
	public CozinhaModelV2 adicionar(
			@ApiParam(name = "corpo", value = "Representação de uma nova cozinha") 
			CozinhaInputV2 cozinhaInput);
	
	@ApiOperation("Atualiza uma cozinha por ID")
	public CozinhaModelV2 atualizar(
			@ApiParam(value = "ID de uma cozinha", example = "1", required = true) 
			Long cozinhaId,
			
			@ApiParam(name = "corpo", value = "Representação de uma cozinha com novas informações")
			CozinhaInputV2 cozinhaInput);	

	@ApiOperation(value = "Remove uma cozinha por ID")
	public void remover(@ApiParam(value = "ID de uma cozinha", example = "1") Long cozinhaId);
	
}
