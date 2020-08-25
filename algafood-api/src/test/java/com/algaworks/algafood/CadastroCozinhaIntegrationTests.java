package com.algaworks.algafood;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

import org.hibernate.validator.internal.util.Contracts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CadastroCozinhaIntegrationTests {

	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	@Test
	public void testarCadastroCozinhaComSucesso() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Chinesa");
		
		novaCozinha = cadastroCozinha.salvar(novaCozinha);
		
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
		
	}
	
	@Test
	public void testarCadastroCozinhaSemNome() {
		Assertions.assertThrows(ConstraintViolationException.class, () -> {
			Cozinha novaCozinha = new Cozinha();
			novaCozinha.setNome(null);

			novaCozinha = cadastroCozinha.salvar(novaCozinha);
		});

	}

}
