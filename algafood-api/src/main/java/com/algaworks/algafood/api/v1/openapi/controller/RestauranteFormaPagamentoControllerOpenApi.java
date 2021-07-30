package com.algaworks.algafood.api.v1.openapi.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.v1.model.FormaPagamentoModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Restaurantes")
public interface RestauranteFormaPagamentoControllerOpenApi {

	@ApiResponses({
		@ApiResponse(code = 404, message = "Restaurante não encontrado")
	})
	@ApiOperation("Lista as formas de pagamento de um restaurante")
	public CollectionModel<FormaPagamentoModel> listar(@ApiParam(value="ID do restaurante", example = "1") Long restauranteId);
	
	@ApiResponses({
		@ApiResponse(code = 204, message = "Desassociação realizada com sucesso"),
		@ApiResponse(code = 404, message = "Forma de pagamento ou restaurante nao encontrado")
		
	})
	@ApiOperation("Desassocia uma forma de pagamento de um restaurante")
	public ResponseEntity<Void> desassociar(
			@ApiParam(value="ID do restaurante", example = "1")
			Long restauranteId, 
			
			@ApiParam(value="ID da forma de pagamento", example = "1")
			Long formaPagamentoId);
	
	

	@ApiResponses({
		@ApiResponse(code = 204, message = "Associação realizada com sucesso"),
		@ApiResponse(code = 404, message = "Forma de pagamento ou restaurante nao encontrado")
		
	})
	@ApiOperation("Associa uma forma de pagamento de um restaurante")
	public ResponseEntity<Void> associar(
			@ApiParam(value="ID do restaurante", example = "1")
			Long restauranteId,
			
			@ApiParam(value="ID da forma de pagamento", example = "1")
			Long formaPagamentoId);	
}
