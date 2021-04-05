package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.UsuarioModel;
import com.algaworks.algafood.api.model.input.SenhaInput;
import com.algaworks.algafood.api.model.input.UsuarioComSenhaInput;
import com.algaworks.algafood.api.model.input.UsuarioInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Usuários")
public interface UsuarioControllerOpenApi {

	@ApiOperation(value = "Lista os usuários")
	public List<UsuarioModel> listar();
	
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "ID da cidade inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Cidade não encontrada", response = Problem.class) })
	@ApiOperation("Busca um usuário por ID")
	public UsuarioModel buscar(
			@ApiParam(value = "ID do usuário", example = "1", required = true)
			Long usuarioId);
	
	@ApiResponses({
		@ApiResponse(code = 201, message = "Usuário criado com sucesso")
	})
	@ApiOperation("Adiciona um novo usuário")
	public UsuarioModel adicionar(
			@ApiParam(name = "corpo", value = "Representação de um novo usuário")
			UsuarioComSenhaInput usuarioInput);
	
	@ApiOperation("Atualiza um usuário por ID")
	public UsuarioModel atualizar(
			@ApiParam(value = "ID do usuário", example = "1", required = true)
			Long usuarioId, 
			
			@ApiParam(name = "corpo", value = "Representação de um usuário com novas informações")
			UsuarioInput usuarioInput);
	
	@ApiResponses({
		@ApiResponse(code = 204, message = "Usuário removido com sucesso")
	})
	@ApiOperation("Remove um usuário por ID")
	public void remover(
			@ApiParam(value = "ID do usuário", example = "1", required = true)
			Long usuarioId);
	
	@ApiResponses({
		@ApiResponse(code = 204, message = "Senha alterada com sucesso")
	})
	@ApiOperation("Altera a senha de um usuário")
    public void alterarSenha(
			@ApiParam(value = "ID do usuário", example = "1", required = true)
    		Long usuarioId, 
    		
    		@ApiParam(name = "corpo", value = "Altera senha do usuário")
    		SenhaInput senha);
	
}
