package com.algaworks.algafood.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.AlgaLinks;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class RootEntryPointController {

	@Autowired
	private AlgaLinks algaLinks;
	
	@GetMapping
	public RootEntryPointModel root() {
		var rootEntryPointModel = new RootEntryPointModel();
		
		rootEntryPointModel.add(algaLinks.linkToCozinhas());
		rootEntryPointModel.add(algaLinks.linkToPedidos("pedidos"));
		rootEntryPointModel.add(algaLinks.linkToRestaurantes("restaurantes"));
		rootEntryPointModel.add(algaLinks.linkToGrupos("grupos"));
		rootEntryPointModel.add(algaLinks.linkToUsuarios());
		rootEntryPointModel.add(algaLinks.linkToPermissoes());
		rootEntryPointModel.add(algaLinks.linkToFormasPagamento());
		rootEntryPointModel.add(algaLinks.linkToEstados());
		rootEntryPointModel.add(algaLinks.linkToCidades());
		
		return rootEntryPointModel;
	}
	
	private static class RootEntryPointModel extends RepresentationModel<RootEntryPointModel> {
		
	}

}