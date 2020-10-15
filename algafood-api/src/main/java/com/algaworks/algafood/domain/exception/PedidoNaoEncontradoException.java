package com.algaworks.algafood.domain.exception;

public class PedidoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	private static final String MSG_PEDIDO_NAO_ENCONTRADO = "Não existe um cadastro de pedido com o código %d";;

	public PedidoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public PedidoNaoEncontradoException(Long cozinhaId) {
		this(String.format(MSG_PEDIDO_NAO_ENCONTRADO, cozinhaId));
	}
}
