package com.algaworks.algafood.api;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.TemplateVariable;
import org.springframework.hateoas.TemplateVariable.VariableType;
import org.springframework.hateoas.TemplateVariables;
import org.springframework.hateoas.UriTemplate;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.controller.CidadeController;
import com.algaworks.algafood.api.controller.CozinhaController;
import com.algaworks.algafood.api.controller.EstadoController;
import com.algaworks.algafood.api.controller.FluxoPedidoController;
import com.algaworks.algafood.api.controller.FormaPagamentoController;
import com.algaworks.algafood.api.controller.PedidoController;
import com.algaworks.algafood.api.controller.RestauranteController;
import com.algaworks.algafood.api.controller.RestauranteProdutoController;
import com.algaworks.algafood.api.controller.RestauranteResponsavelController;
import com.algaworks.algafood.api.controller.UsuarioController;

@Component
public class AlgaLinks {
	public static final TemplateVariables PAGE_VARIABLES = new TemplateVariables(
				new TemplateVariable("page", VariableType.REQUEST_PARAM),
				new TemplateVariable("size", VariableType.REQUEST_PARAM),
				new TemplateVariable("sort", VariableType.REQUEST_PARAM));

	public Link linkToPedidos() {
        TemplateVariables filtroVariables = new TemplateVariables(
        		new TemplateVariable("clienteId", VariableType.REQUEST_PARAM),
        		new TemplateVariable("restauranteId", VariableType.REQUEST_PARAM),
        		new TemplateVariable("dataCriacaoInicio", VariableType.REQUEST_PARAM),
        		new TemplateVariable("dataCriacaoFim", VariableType.REQUEST_PARAM));
        
        String pedidosUrl = linkTo(PedidoController.class).toUri().toASCIIString();
        return new Link(UriTemplate.of(pedidosUrl, PAGE_VARIABLES.concat(filtroVariables)), "pedidos");
	}
	
	public Link linkToRestaurante(Long id) {
		return linkToRestaurante(id, IanaLinkRelations.SELF.value());
	}
	
	public Link linkToRestaurante(Long id, String rel) {
		return linkTo(methodOn(RestauranteController.class).buscar(id)).withRel(rel);
	}
	
	public Link linkToRestaurantes() {
		return linkTo(methodOn(RestauranteController.class).listar()).withSelfRel();
	}
	
	public Link linkToUsuario(Long id) {
		return linkToUsuario(id, IanaLinkRelations.SELF.value());
	}
	
	public Link linkToUsuario(Long id, String rel) {
		return linkTo(methodOn(UsuarioController.class).buscar(id)).withRel(rel);
	}
	
	public Link linkToUsuarios() {
		return linkTo(UsuarioController.class).withRel("usuarios");
	}
	
	public Link linkToFormaPagamento(Long id) {
		return linkToFormaPagamento(id, IanaLinkRelations.SELF.value());
	}
	
	public Link linkToFormaPagamento(Long id, String rel) {
		return linkTo(methodOn(FormaPagamentoController.class).buscar(id)).withRel(rel);
	}
	
	public Link linkToFormasPagamento() {
		return linkTo(methodOn(FormaPagamentoController.class).listar()).withSelfRel();
	}
	
	public Link linkToCidade(Long id) {
		return linkToCidade(id, IanaLinkRelations.SELF.value());
	}
	
	public Link linkToCidade(Long id, String rel) {
		return linkTo(methodOn(CidadeController.class).buscar(id)).withRel(rel);
	}
	
	public Link linkToCidades() {
		return linkTo(methodOn(CidadeController.class).listar()).withSelfRel();
	}
	
	public Link linkToProduto(Long restauranteId, Long produtoId) {
		return linkToProduto(restauranteId, produtoId, "produto");
	}
	
	public Link linkToProduto(Long restauranteId, Long produtoId, String rel) {
		return linkTo(methodOn(RestauranteProdutoController.class).buscar(restauranteId, produtoId)).withRel(rel);
	}
	
	public Link linkToConfirmacaoPedido(String codigoPedido, String rel) {
		return linkTo(methodOn(FluxoPedidoController.class).confirmar(codigoPedido)).withRel(rel);
	}
	
	public Link linkToEntregarPedido(String codigoPedido, String rel) {
		return linkTo(methodOn(FluxoPedidoController.class).entregar(codigoPedido)).withRel(rel);
	}
	
	public Link linkToCancelarPedido(String codigoPedido, String rel) {
		return linkTo(methodOn(FluxoPedidoController.class).cancelar(codigoPedido)).withRel(rel);
	}
	
	public Link linkToEstado(Long id) {
		return linkToEstado(id, IanaLinkRelations.SELF.value());
	}
	
	public Link linkToEstado(Long id, String rel) {
		return linkTo(methodOn(EstadoController.class).buscar(id)).withRel(rel);
	}
	
	public Link linkToEstados() {
		return linkTo(EstadoController.class).withRel("estados");
	}
	
	public Link linkToCozinhas() {
		return linkTo(CozinhaController.class).withRel("cozinhas");
	}
	
	public Link linkToRestauranteResponsavel (long restauranteId) {
		return linkTo(methodOn(RestauranteResponsavelController.class).listar(restauranteId)).withSelfRel();
	}
}



