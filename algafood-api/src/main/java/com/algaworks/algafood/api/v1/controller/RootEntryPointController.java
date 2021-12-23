package com.algaworks.algafood.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.v1.AlgaLinks;
import com.algaworks.algafood.core.security.AlgaSecurity;

@RestController
@RequestMapping(path = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class RootEntryPointController {

	@Autowired
	private AlgaLinks algaLinks;

	@Autowired
	private AlgaSecurity algaSecurity;

	@GetMapping
	public RootEntryPointModel root() {
		var rootEntryPointModel = new RootEntryPointModel();

		if (algaSecurity.podeConsultarCozinhas()) {
			rootEntryPointModel.add(algaLinks.linkToCozinhas());
		}

		if (algaSecurity.podePesquisarPedidos()) {
			rootEntryPointModel.add(algaLinks.linkToPedidos("pedidos"));
		}

		if (algaSecurity.podeConsultarRestaurantes()) {
			rootEntryPointModel.add(algaLinks.linkToRestaurantes("restaurantes"));
		}

		if (algaSecurity.podeConsultarUsuariosGruposPermissoes()) {
			rootEntryPointModel.add(algaLinks.linkToGrupos("grupos"));
			rootEntryPointModel.add(algaLinks.linkToUsuarios());
			rootEntryPointModel.add(algaLinks.linkToPermissoes());
		}

		if (algaSecurity.podeConsultarFormasPagamento()) {
			rootEntryPointModel.add(algaLinks.linkToFormasPagamento());
		}

		if (algaSecurity.podeConsultarEstados()) {
			rootEntryPointModel.add(algaLinks.linkToEstados());
		}

		if (algaSecurity.podeConsultarCidades()) {
			rootEntryPointModel.add(algaLinks.linkToCidades());
		}

		if (algaSecurity.podeConsultarEstatisticas()) {
			rootEntryPointModel.add(algaLinks.linkToEstatisticas("estatisticas"));
		}

		return rootEntryPointModel;
	}

	private static class RootEntryPointModel extends RepresentationModel<RootEntryPointModel> {

	}

}