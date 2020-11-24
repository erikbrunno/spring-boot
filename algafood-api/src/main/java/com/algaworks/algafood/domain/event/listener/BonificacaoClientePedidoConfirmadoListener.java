package com.algaworks.algafood.domain.event.listener;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import com.algaworks.algafood.domain.event.PedidoConfirmadoEvent;

@Component
public class BonificacaoClientePedidoConfirmadoListener {

	@TransactionalEventListener
	public void aoConfirmarPedido(PedidoConfirmadoEvent event) {
		System.out.println("Calculando os pontos para " + event.getPedido().getCliente().getNome());
	}
	
}
