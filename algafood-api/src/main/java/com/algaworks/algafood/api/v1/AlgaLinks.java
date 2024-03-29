package com.algaworks.algafood.api.v1;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.TemplateVariable;
import org.springframework.hateoas.TemplateVariable.VariableType;
import org.springframework.hateoas.TemplateVariables;
import org.springframework.hateoas.UriTemplate;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.v1.controller.CidadeController;
import com.algaworks.algafood.api.v1.controller.CozinhaController;
import com.algaworks.algafood.api.v1.controller.EstadoController;
import com.algaworks.algafood.api.v1.controller.EstatisticasController;
import com.algaworks.algafood.api.v1.controller.FluxoPedidoController;
import com.algaworks.algafood.api.v1.controller.FormaPagamentoController;
import com.algaworks.algafood.api.v1.controller.GrupoController;
import com.algaworks.algafood.api.v1.controller.GrupoPermissaoController;
import com.algaworks.algafood.api.v1.controller.PedidoController;
import com.algaworks.algafood.api.v1.controller.PermissaoController;
import com.algaworks.algafood.api.v1.controller.RestauranteController;
import com.algaworks.algafood.api.v1.controller.RestauranteFormaPagamentoController;
import com.algaworks.algafood.api.v1.controller.RestauranteProdutoController;
import com.algaworks.algafood.api.v1.controller.RestauranteProdutoFotoController;
import com.algaworks.algafood.api.v1.controller.RestauranteResponsavelController;
import com.algaworks.algafood.api.v1.controller.UsuarioController;
import com.algaworks.algafood.api.v1.controller.UsuarioGrupoController;

@Component
public class AlgaLinks {
	public static final TemplateVariables PAGE_VARIABLES = new TemplateVariables(
				new TemplateVariable("page", VariableType.REQUEST_PARAM),
				new TemplateVariable("size", VariableType.REQUEST_PARAM),
				new TemplateVariable("sort", VariableType.REQUEST_PARAM));

	public Link linkToPedidos(String rel) {
        TemplateVariables filtroVariables = new TemplateVariables(
        		new TemplateVariable("clienteId", VariableType.REQUEST_PARAM),
        		new TemplateVariable("restauranteId", VariableType.REQUEST_PARAM),
        		new TemplateVariable("dataCriacaoInicio", VariableType.REQUEST_PARAM),
        		new TemplateVariable("dataCriacaoFim", VariableType.REQUEST_PARAM));
        
        String pedidosUrl = linkTo(PedidoController.class).toUri().toASCIIString();
        return new Link(UriTemplate.of(pedidosUrl, PAGE_VARIABLES.concat(filtroVariables)), rel);
	}
	
	public Link linkToRestaurante(Long id) {
		return linkToRestaurante(id, IanaLinkRelations.SELF.value());
	}
	
	public Link linkToRestaurante(Long id, String rel) {
		return linkTo(methodOn(RestauranteController.class).buscar(id)).withRel(rel);
	}
	
	public Link linkToRestaurantes(String rel) {
		TemplateVariables filtroVariables = new TemplateVariables(
        		new TemplateVariable("projecao", VariableType.REQUEST_PARAM));
        
        String restauranteUrl = linkTo(RestauranteController.class).toUri().toASCIIString();
        return new Link(UriTemplate.of(restauranteUrl, filtroVariables), rel);
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
	
	public Link linkToProdutos(Long restauranteId, String rel) {
	    return linkTo(methodOn(RestauranteProdutoController.class)
	            .listar(restauranteId, null)).withRel(rel);
	}

	public Link linkToProdutos(Long restauranteId) {
	    return linkToProdutos(restauranteId, IanaLinkRelations.SELF.value());
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
	
	public Link linkToCozinha(Long id) {
		return linkToCozinha(id, IanaLinkRelations.SELF.value());
	}
	
	public Link linkToCozinha(Long id, String rel) {
		return linkTo(methodOn(CozinhaController.class).buscar(id)).withRel(rel);
	}
	
	public Link linkToCozinhas() {
		return linkTo(CozinhaController.class).withRel("cozinhas");
	}
	
	public Link linkToRestauranteResponsavel (long restauranteId) {
		return linkTo(methodOn(RestauranteResponsavelController.class).listar(restauranteId)).withSelfRel();
	}
	
	public Link linkToRestauranteResponsavelDesassociacao(Long restauranteId, Long usuarioId, String rel) {

		return linkTo(methodOn(RestauranteResponsavelController.class).desassociar(restauranteId, usuarioId))
				.withRel(rel);
	}

	public Link linkToRestauranteResponsavelAssociacao(Long restauranteId, String rel) {
		return linkTo(methodOn(RestauranteResponsavelController.class).associar(restauranteId, null)).withRel(rel);
	}
	
	public Link linkToRestauranteFormasPagamento(Long restauranteId, String rel) {
	    return linkTo(methodOn(RestauranteFormaPagamentoController.class)
	            .listar(restauranteId)).withRel(rel);
	}
	
	public Link linkToRestauranteFormaPagamentoDesassociacao(
			Long restauranteId, Long formaPagamentoId, String rel) {
		return linkTo(methodOn(RestauranteFormaPagamentoController.class)
				.desassociar(restauranteId, formaPagamentoId)).withRel(rel);
	}
	
	public Link linkToRestauranteFormaPagamentoAssociacao(
			Long restauranteId, String rel) {
		
		return linkTo(methodOn(RestauranteFormaPagamentoController.class)
				.associar(restauranteId, null)).withRel(rel);
	}
	
	public Link linkToRestauranteAbertura(Long restauranteId, String rel) {
	    return linkTo(methodOn(RestauranteController.class)
	            .abrir(restauranteId)).withRel(rel);
	}

	public Link linkToRestauranteFechamento(Long restauranteId, String rel) {
	    return linkTo(methodOn(RestauranteController.class)
	            .fechar(restauranteId)).withRel(rel);
	}

	public Link linkToRestauranteInativacao(Long restauranteId, String rel) {
	    return linkTo(methodOn(RestauranteController.class)
	            .inativar(restauranteId)).withRel(rel);
	}

	public Link linkToRestauranteAtivacao(Long restauranteId, String rel) {
	    return linkTo(methodOn(RestauranteController.class)
	            .ativar(restauranteId)).withRel(rel);
	}
	
	public Link linkToFotoProduto(Long restauranteId, Long produtoId, String rel) {
	    return linkTo(methodOn(RestauranteProdutoFotoController.class)
	            .buscar(restauranteId, produtoId)).withRel(rel);
	}

	public Link linkToFotoProduto(Long restauranteId, Long produtoId) {
	    return linkToFotoProduto(restauranteId, produtoId, IanaLinkRelations.SELF.value());
	}
	
	public Link linkToGrupos(String rel) {
		return linkTo(methodOn(GrupoController.class).listar()).withRel(rel);
	}
	
	public Link linkToGrupoPermissoes(Long grupoId, String rel) {
		return linkTo(methodOn(GrupoPermissaoController.class).listar(grupoId)).withRel(rel);
	}
	
	public Link linkToGrupoPermissaoAssociacao(Long grupoId, String rel) {
		return linkTo(methodOn(GrupoPermissaoController.class).associar(grupoId, null))
				.withRel(rel);
	}
	
	public Link linkToGrupoPermissaoDesassociacao(Long grupoId, Long permissaoId, String rel) {
		return linkTo(methodOn(GrupoPermissaoController.class).desassociar(grupoId, permissaoId))
				.withRel(rel);
	}
	
	public Link linkToPermissoes() {
		return linkTo(methodOn(PermissaoController.class).listar()).withRel("permissoes");
	}
	
	public Link linkToGruposDoUsuario(Long usuarioId, String rel) {
		return linkTo(methodOn(UsuarioGrupoController.class).lista(usuarioId)).withRel(rel);
	}
	
	public Link linkToGrupoUsuarioDesassociacao(Long usuarioId, Long grupoId, String rel) {
		return linkTo(methodOn(UsuarioGrupoController.class).desassociar(usuarioId, grupoId)).withRel(rel);
	}
	
	public Link linkToGrupoUsuarioAssociacao(Long usuarioId, String rel) {
		return linkTo(methodOn(UsuarioGrupoController.class).associar(usuarioId, null)).withRel(rel);
	}
	
	public Link linkToEstatisticas(String rel) {
	    return linkTo(EstatisticasController.class).withRel(rel);
	}

	public Link linkToEstatisticasVendasDiarias(String rel) {
	    TemplateVariables filtroVariables = new TemplateVariables(
	            new TemplateVariable("restauranteId", VariableType.REQUEST_PARAM),
	            new TemplateVariable("dataCriacaoInicio", VariableType.REQUEST_PARAM),
	            new TemplateVariable("dataCriacaoFim", VariableType.REQUEST_PARAM),
	            new TemplateVariable("timeOffset", VariableType.REQUEST_PARAM));
	    
	    String pedidosUrl = linkTo(methodOn(EstatisticasController.class)
	            .consultarVendasDiarias(null, null)).toUri().toString();
	    
	    return new Link(UriTemplate.of(pedidosUrl, filtroVariables), rel);
	}
}



