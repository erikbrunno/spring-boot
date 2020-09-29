package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.exception.ProdutoNaoEncontradoException;
import com.algaworks.algafood.domain.exception.RestauranteNaoEncontradoException;
import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.ProdutoRepository;

@Service
public class CadastroProdutoService {

	private static final String MSG_PRODUTO_EM_USO = "Produto de código %d não pode ser removida, pois está em uso";

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CadastroRestauranteService cadastroRestaurante;

	@Transactional
	public Produto salvar(Produto produto) {
		Restaurante restaurante = cadastroRestaurante.buscar(produto.getRestaurante().getId());
		produto.setRestaurante(restaurante);
		try {
			return produtoRepository.save(produto);
		} catch (RestauranteNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}
//	
//	@Transactional
//	public void excluir(Long formaPagamentoId) {
//		try {
//			formaPagamentoRepository.deleteById(formaPagamentoId);
//			formaPagamentoRepository.flush();
//		} catch (EmptyResultDataAccessException e) {
//			throw new FormaPagamentoNaoEncontradaException(formaPagamentoId);
//		} catch (DataIntegrityViolationException e) {
//			throw new EntidadeEmUsoException(String.format(MSG_PRODUTO_EM_USO, formaPagamentoId));
//		}
//	}
//	
	public Produto buscar(Long restauranteId, Long produtoId) {
		return produtoRepository.findById(restauranteId, produtoId)
				.orElseThrow(() -> new ProdutoNaoEncontradoException(restauranteId, produtoId));
	}
}
