package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.model.FormaPagamentoModel;
import com.algaworks.algafood.api.v1.model.input.FormaPagamentoInput;
import com.algaworks.algafood.api.v1.openapi.model.FormasPagamentoModelOpenApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "FormaPagamento")
public interface FormaPagamentoOpenApi {

	@ApiOperation(value = "Lista de formas de pagamento", response = FormasPagamentoModelOpenApi.class)
	public CollectionModel<FormaPagamentoModel> listar();
	
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
