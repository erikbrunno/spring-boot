package com.algaworks.algafood.api.openapi.controller;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.model.PermissaoModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "permissoes")
public interface PermissaoControllerOpenApi {

	@ApiOperation("Lista de permissoes")
	public CollectionModel<PermissaoModel> listar();	

	
}
