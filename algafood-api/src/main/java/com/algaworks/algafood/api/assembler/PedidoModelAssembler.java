package com.algaworks.algafood.api.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.controller.CidadeController;
import com.algaworks.algafood.api.controller.FormaPagamentoController;
import com.algaworks.algafood.api.controller.PedidoController;
import com.algaworks.algafood.api.controller.RestauranteController;
import com.algaworks.algafood.api.controller.RestauranteProdutoController;
import com.algaworks.algafood.api.controller.UsuarioController;
import com.algaworks.algafood.api.model.PedidoModel;
import com.algaworks.algafood.domain.model.Pedido;

@Component
public class PedidoModelAssembler extends RepresentationModelAssemblerSupport<Pedido, PedidoModel> {

	public PedidoModelAssembler() {
		super(PedidoController.class, PedidoModel.class);
	}
	
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public PedidoModel toModel(Pedido pedido) {
        PedidoModel pedidoModel = createModelWithId(pedido.getId(), pedido);
        modelMapper.map(pedido, pedidoModel);
        
        pedidoModel.add(linkTo(PedidoController.class).withRel("pedidos"));
        
        pedidoModel.getRestaurante().add(linkTo(methodOn(RestauranteController.class).buscar(pedido.getRestaurante().getId()))
        		.withSelfRel());
        pedidoModel.getRestaurante().add(linkTo(methodOn(RestauranteController.class).listar()).withSelfRel());
        
        pedidoModel.getCliente().add(linkTo(methodOn(UsuarioController.class).buscar(pedido.getCliente().getId()))
        		.withSelfRel());
        
        pedidoModel.getFormaPagamento().add(linkTo(methodOn(FormaPagamentoController.class).buscar(pedidoModel.getFormaPagamento().getId()))
        		.withSelfRel());
        pedidoModel.getFormaPagamento().add(linkTo(methodOn(FormaPagamentoController.class).listar()).withSelfRel());
        
        pedidoModel.getEnderecoEntrega().getCidade().add(linkTo(methodOn(CidadeController.class).buscar(pedidoModel.getEnderecoEntrega().getCidade().getId()))
        		.withSelfRel());
        pedidoModel.getEnderecoEntrega().getCidade().add(linkTo(methodOn(CidadeController.class).listar()).withSelfRel());
        
        pedidoModel.getItens().forEach(item -> {
            item.add(linkTo(methodOn(RestauranteProdutoController.class)
                    .buscar(pedidoModel.getRestaurante().getId(), item.getProdutoId()))
                    .withRel("produto"));
        });
        
        return pedidoModel;
    }
    
    
    
}