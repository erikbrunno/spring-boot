package com.algaworks.algafood.domain.event.listener;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.algaworks.algafood.domain.event.PedidoConfirmadoEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BonificacaoClientePedidoConfirmadoListener {

	@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
	public void aoConfirmarPedido(PedidoConfirmadoEvent event) {
		log.info(String.format("Calculando os pontos para %s", event.getPedido().getCliente().getNome()));
	}
	
}
