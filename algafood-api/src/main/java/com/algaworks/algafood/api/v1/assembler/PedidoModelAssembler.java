package com.algaworks.algafood.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.v1.AlgaLinks;
import com.algaworks.algafood.api.v1.controller.PedidoController;
import com.algaworks.algafood.api.v1.model.PedidoModel;
import com.algaworks.algafood.domain.model.Pedido;

@Component
public class PedidoModelAssembler extends RepresentationModelAssemblerSupport<Pedido, PedidoModel> {

	public PedidoModelAssembler() {
		super(PedidoController.class, PedidoModel.class);
	}
	
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private AlgaLinks algaLinks;
    
    @Override
    public PedidoModel toModel(Pedido pedido) {
        PedidoModel pedidoModel = createModelWithId(pedido.getId(), pedido);
        modelMapper.map(pedido, pedidoModel);
        
        pedidoModel.add(algaLinks.linkToPedidos("pedidos"));
        
        if (pedido.podeSerConfirmado()) {        	
        	pedidoModel.add(algaLinks.linkToConfirmacaoPedido(pedido.getCodigo(), "confirmar"));
        }
        
        if (pedido.podeSerEntregue()) {
        	pedidoModel.add(algaLinks.linkToEntregarPedido(pedido.getCodigo(), "entregar"));
        }
        
        if (pedido.podeSerEntregue()) {        	
        	pedidoModel.add(algaLinks.linkToCancelarPedido(pedido.getCodigo(), "cancelar"));
        }

        
        pedidoModel.getRestaurante().add(algaLinks.linkToRestaurante(pedidoModel.getRestaurante().getId()));
        pedidoModel.getRestaurante().add(algaLinks.linkToRestaurantes("restaurantes"));
        
        pedidoModel.getCliente().add(algaLinks.linkToUsuario(pedidoModel.getCliente().getId()));
        
        pedidoModel.getFormaPagamento().add(algaLinks.linkToFormaPagamento(pedidoModel.getFormaPagamento().getId()));
        pedidoModel.getFormaPagamento().add(algaLinks.linkToFormasPagamento());
        
        pedidoModel.getEnderecoEntrega().getCidade().add(algaLinks.linkToCidade(pedidoModel.getEnderecoEntrega().getCidade().getId()));
        pedidoModel.getEnderecoEntrega().getCidade().add(algaLinks.linkToCidades());
        
        pedidoModel.getItens().forEach(item -> {
            item.add(algaLinks.linkToProduto(pedidoModel.getRestaurante().getId(), item.getProdutoId()));
        });
        
        return pedidoModel;
    }
    
    
    
}