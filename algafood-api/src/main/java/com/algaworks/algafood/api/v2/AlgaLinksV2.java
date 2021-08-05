package com.algaworks.algafood.api.v2;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.v1.controller.CozinhaController;
import com.algaworks.algafood.api.v2.controller.CidadeControllerV2;

@Component
public class AlgaLinksV2 {
	
	public Link linkToCidades() {
		return linkTo(methodOn(CidadeControllerV2.class).listar())
				.withSelfRel();
	}

	public Link linkToCozinhas() {
		return linkTo(CozinhaController.class).withRel("cozinhas");
	}
	
}



