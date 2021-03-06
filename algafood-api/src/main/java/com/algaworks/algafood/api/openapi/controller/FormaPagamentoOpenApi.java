package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.FormaPagamentoModel;
import com.algaworks.algafood.api.model.input.FormaPagamentoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "FormaPagamento")
public interface FormaPagamentoOpenApi {

	@ApiOperation("Lista de formas de pagamento")
	public List<FormaPagamentoModel> listar();
	
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "ID da forma de pagamento inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Forma de pagamento não encontrada", response = Problem.class) })
	@ApiOperation("Busca uma forma de pagamento por ID")
	public FormaPagamentoModel buscar(@ApiParam(value = "ID da forma de pagamento", example = "1", required = true) Long formaPagamentoId);
	
	@ApiOperation("Adiciona uma forma de pagamento")
	public FormaPagamentoModel adicionar(
			@ApiParam(name="corpo", value = "Representação de uma nova forma de pagamento") FormaPagamentoInput formaPagamentoInput);
	
	@ApiOperation("Altera uma forma de pagamento")
	public FormaPagamentoModel atualizar(
			@ApiParam(value="ID da forma de pagamento", example = "1", required = true)
			Long formaPagamentoId,
			
			@ApiParam(name="corpo", value = "Representação de uma forma de pagamento com novas informações")
			FormaPagamentoInput formaPagamentoInput);	
	
	@ApiOperation("Remove uma forma de pagamento")
	public void remover(@ApiParam(value="ID da forma de pagamento", example = "1", required = true) Long formaPagamentoId);
	
}
