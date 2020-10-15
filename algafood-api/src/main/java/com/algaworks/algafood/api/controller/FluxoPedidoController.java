package com.algaworks.algafood.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.service.FluxoPedidoService;

@RestController
@RequestMapping("/pedidos/{pedidoId}")
public class FluxoPedidoController {

	@Autowired
	private FluxoPedidoService fluxoPedido;
	
	@PutMapping("/confirmacao")
	@ResponseStatus(HttpStatus.CREATED)
	public void confirmar(@PathVariable Long pedidoId) {
		fluxoPedido.confimar(pedidoId);
	}
	
	@PutMapping("/cancelar")
	@ResponseStatus(HttpStatus.CREATED)
	public void cancelar(@PathVariable Long pedidoId) {
		fluxoPedido.cancelar(pedidoId);
	}
	
	@PutMapping("/entregar")
	@ResponseStatus(HttpStatus.CREATED)
	public void entregar(@PathVariable Long pedidoId) {
		fluxoPedido.entregar(pedidoId);
	}
	
}
