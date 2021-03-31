package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.CozinhaModel;
import com.algaworks.algafood.api.model.CozinhasXmlWrapper;
import com.algaworks.algafood.api.model.GrupoModel;
import com.algaworks.algafood.api.model.input.CozinhaInput;
import com.algaworks.algafood.api.model.input.GrupoInput;
import com.algaworks.algafood.domain.model.Cozinha;

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
	public CozinhaModel buscar(Long cozinhaId);
	
	@ApiOperation("Adiciona uma cozinha")
	public CozinhaModel adicionar(
			@ApiParam(name = "corpo", value = "Representação de uma nova cozinha") 
			CozinhaInput cozinhaInput);
	
	@ApiOperation("Atualiza uma cozinha por ID")
	public CozinhaModel atualizar(
			@ApiParam(value = "ID de uma cozinha", example = "1") 
			Long cozinhaId,
			
			@ApiParam(name = "corpo", value = "Representação de uma cozinha com novas informações")
			CozinhaInput cozinhaInput);	

	@ApiOperation("Remove uma cozinha por ID")
	public void remover(Long cozinhaId);
	
}
