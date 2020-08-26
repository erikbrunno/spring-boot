package com.algaworks.algafood;

import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.util.DatabaseCleaner;
import com.algaworks.algafood.util.ResourceUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class CadastroCozinhaIT {

	private static final int COZINHA_ID_INEXISTENTE = 2004;

	private static final String PATH_COZINHAS = "/cozinhas";
	
	@LocalServerPort
	private int port;
	
//	@Autowired
//	private Flyway flyway;
	
	@Autowired
	private DatabaseCleaner dataBaseCleaner;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	private Cozinha cozinhaIndiana;
	
	private String jsonCorretoCozinhaChinesa;
	
	private int quantidadeCozinhasCadastradas;
	
	@Before
	public void setUp() {
		// Habilita os loggin quando o teste falhar
		enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = PATH_COZINHAS;
		
		dataBaseCleaner.clearTables();
		prepararCozinha();
		
		jsonCorretoCozinhaChinesa = ResourceUtils.getContentFromResource(
				"/json/inserir_cozinha.json");
		
		/*
		 * Executamos o afterMigrate.sql para resetar o banco de dados
		 * quando estavamos apontando para o application.properties,
		 * como agora estamos apontando para application-test.properties
		 * não há mais necessidade de executar esse comando
		 */
		//Executar o afterMigrate.sql resentando o banco de dados
//		flyway.migrate();
	}

	@Test
	public void deveRetornarStatus200_QuandoConsultarCozinhas() {

		// @formatter:off
		given()
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.OK.value());
		// @formatter:on
	}

	@Test
	public void deveConter4Cozinhas_QuandoConsultarCozinhas() {
		
		// @formatter:off
		given()
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.body("", hasSize(quantidadeCozinhasCadastradas))
			.body("titulo", hasItems("Indiana", "Tailandesa"));
		// @formatter:on
	}
	
	@Test
	public void deveRetornarStatus201_QuandoCadastrarCozinha() {
		// @formatter:off
		given()
			.body(jsonCorretoCozinhaChinesa)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.CREATED.value());
		// @formatter:on
	}
	
	@Test
	public void deveRetornarRespostaEStatus200_QuandoConsultarCozinhaExistente() {
		// @formatter:off
		given()
			.pathParam("cozinhaId", 2)
			.accept(ContentType.JSON)
		.when()
			.get("/{cozinhaId}")
		.then()
			.statusCode(HttpStatus.OK.value())
			.body("titulo", equalTo(cozinhaIndiana.getNome()));
		// @formatter:on
	}
	
	@Test
	public void deveRetornarRespostaEStatus404_QuandoConsultarCozinhaInexistente() {
		// @formatter:off
		given()
			.pathParam("cozinhaId", COZINHA_ID_INEXISTENTE)
			.accept(ContentType.JSON)
		.when()
			.get("/{cozinhaId}")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
		// @formatter:on
	}
	
	private void prepararCozinha() {
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Tailandesa");
		cozinhaRepository.save(cozinha1);
		
		cozinhaIndiana = new Cozinha();
		cozinhaIndiana.setNome("Indiana");
		cozinhaRepository.save(cozinhaIndiana);
		
		Cozinha cozinha3 = new Cozinha();
		cozinha3.setNome("Americana");
		cozinhaRepository.save(cozinha3);
		
		quantidadeCozinhasCadastradas = (int) cozinhaRepository.count();
	}
	

}