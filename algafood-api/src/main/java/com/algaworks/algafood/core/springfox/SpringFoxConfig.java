package com.algaworks.algafood.core.springfox;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.model.CidadeModel;
import com.algaworks.algafood.api.v1.model.CozinhaModel;
import com.algaworks.algafood.api.v1.model.EstadoModel;
import com.algaworks.algafood.api.v1.model.FormaPagamentoModel;
import com.algaworks.algafood.api.v1.model.GrupoModel;
import com.algaworks.algafood.api.v1.model.PedidoResumoModel;
import com.algaworks.algafood.api.v1.model.PermissaoModel;
import com.algaworks.algafood.api.v1.model.ProdutoModel;
import com.algaworks.algafood.api.v1.model.RestauranteModel;
import com.algaworks.algafood.api.v1.model.UsuarioModel;
import com.algaworks.algafood.api.v1.openapi.model.CidadesModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.CozinhasModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.EstadosModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.FormasPagamentoModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.GruposModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.LinksModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.PageableModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.PedidosResumoModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.PermissoesModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.ProdutosModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.RestaurantesModelOpenApi;
import com.algaworks.algafood.api.v1.openapi.model.UsuariosModelOpenApi;
import com.algaworks.algafood.api.v2.model.CidadeModelV2;
import com.algaworks.algafood.api.v2.model.CozinhaModelV2;
import com.algaworks.algafood.api.v2.openapi.model.CidadesModelOpenApiV2;
import com.algaworks.algafood.api.v2.openapi.model.CozinhasModelOpenApiV2;
import com.fasterxml.classmate.TypeResolver;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig implements WebMvcConfigurer {

	@Bean
	public Docket apiDocketV1() {
		var typeResolver = new TypeResolver();
		
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("V1")
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.algaworks.algafood.api"))
					.paths(PathSelectors.ant("/v1/*")) //Pra gerar a documentacao apenas da versao 1 da API algafood
//					.paths(PathSelectors.ant("/restaurantes/*"))
					.build()
				
				//Desabilita o status code da faixa 400 quando for escanear
				.useDefaultResponseMessages(false)
				
				//adiciona parametos globais para todos endpoint da api de documentacao
//				.globalOperationParameters(Arrays.asList(
//						new ParameterBuilder()
//						.name("campos")
//						.description("Nomes das propriedades para filtrar na resposta, separados por vírgula")
//						.parameterType("query")
//						.modelRef(new ModelRef("string"))
//						.build()
//						))
				//configura os status globalmente pra cada endpoint, nele informamos quais código e sua descricao
				.globalResponseMessage(RequestMethod.GET, globalGetResponseMessages())
				.globalResponseMessage(RequestMethod.POST, globalPostPutResponseMessages())
	            .globalResponseMessage(RequestMethod.PUT, globalPostPutResponseMessages())
	            .globalResponseMessage(RequestMethod.DELETE, globalDeleteResponseMessages())
	            .ignoredParameterTypes(ServletWebRequest.class)
				.additionalModels(typeResolver.resolve(Problem.class))
				.directModelSubstitute(Pageable.class, PageableModelOpenApi.class)
				.directModelSubstitute(Links.class, LinksModelOpenApi.class)
	            .alternateTypeRules(
	            		AlternateTypeRules.newRule(typeResolver.resolve(PagedModel.class, CozinhaModel.class), 
	            			CozinhasModelOpenApi.class),
	            		AlternateTypeRules.newRule(typeResolver.resolve(PagedModel.class, PedidoResumoModel.class), 
	            				PedidosResumoModelOpenApi.class),
	            		AlternateTypeRules.newRule(typeResolver.resolve(CollectionModel.class, CidadeModel.class), 
	            				CidadesModelOpenApi.class),
	            		AlternateTypeRules.newRule(typeResolver.resolve(CollectionModel.class, EstadoModel.class), 
	            				EstadosModelOpenApi.class),
	            		AlternateTypeRules.newRule(typeResolver.resolve(CollectionModel.class, FormaPagamentoModel.class), 
	            				FormasPagamentoModelOpenApi.class),
	            		AlternateTypeRules.newRule(
	    	            	    typeResolver.resolve(CollectionModel.class, GrupoModel.class),
	    	            	    GruposModelOpenApi.class),
	            		AlternateTypeRules.newRule(
		            	        typeResolver.resolve(CollectionModel.class, PermissaoModel.class),
		            	        PermissoesModelOpenApi.class),
	            		AlternateTypeRules.newRule(
	            			    typeResolver.resolve(CollectionModel.class, ProdutoModel.class),
	            			    ProdutosModelOpenApi.class),
	            		AlternateTypeRules.newRule(
	            			    typeResolver.resolve(CollectionModel.class, RestauranteModel.class),
	            			    RestaurantesModelOpenApi.class),
	            		AlternateTypeRules.newRule(
	            		        typeResolver.resolve(CollectionModel.class, UsuarioModel.class),
	            		        UsuariosModelOpenApi.class)
	            )
	            .securitySchemes(Arrays.asList(securityScheme()))
	            .securityContexts(Arrays.asList(securityContext()))
				.apiInfo(apiInfoV1())
				.tags(new Tag("Cidades", "Gerenciar cidades"),
						new Tag("Grupos", "Gerenciar grupos"),
						new Tag("Cozinhas", "Gerenciar cozinhas"),
						new Tag("FormaPagamento", "Gerenciar formas de pagamento"),
						new Tag("Pedidos", "Gerenciar pedidos"),
						new Tag("Restaurantes", "Gerenciar restaurantes"),
						new Tag("Estados", "Gerenciar Estados"),
				        new Tag("Produtos", "Gerencia os produtos de restaurantes"),
				        new Tag("Usuários", "Gerenciar usuários"),
				        new Tag("Estatísticas", "Estatísticas da AlgaFood"),
				        new Tag("Permissões", "Gerencia as permissões"));
	}
	
	private SecurityScheme securityScheme() {
		return new OAuthBuilder()
				.name("Algafood")
				.grantTypes(grantTypes())
				.scopes(scopes())
				.build();
	}
	
	private List<GrantType> grantTypes() {
		return Arrays.asList(new ResourceOwnerPasswordCredentialsGrant("/oauth/token"));
	}
	
	private List<AuthorizationScope> scopes() {
		return Arrays.asList(new AuthorizationScope("READ", "Acesso de Leitura"),
				new AuthorizationScope("WRITE", "Acesso de Escrita"));
	}
	
	private SecurityContext securityContext() {
		var securityReference = SecurityReference.builder()
				.reference("Algafood")
				.scopes(scopes().toArray(new AuthorizationScope[0]))
				.build();
		
		return SecurityContext.builder()
				.securityReferences(Arrays.asList(securityReference))
				.forPaths(PathSelectors.any())
				.build();
	}
	
	@Bean
	public Docket apiDocketV2() {
		var typeResolver = new TypeResolver();
		
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("V2")
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.algaworks.algafood.api"))
					.paths(PathSelectors.ant("/v2/*")) //Pra gerar a documentacao apenas da versao 1 da API algafood
					.build()
				
				//Desabilita o status code da faixa 400 quando for escanear
				.useDefaultResponseMessages(false)
				
				//configura os status globalmente pra cada endpoint, nele informamos quais código e sua descricao
				.globalResponseMessage(RequestMethod.GET, globalGetResponseMessages())
				.globalResponseMessage(RequestMethod.POST, globalPostPutResponseMessages())
	            .globalResponseMessage(RequestMethod.PUT, globalPostPutResponseMessages())
	            .globalResponseMessage(RequestMethod.DELETE, globalDeleteResponseMessages())
	            .ignoredParameterTypes(ServletWebRequest.class)
				.additionalModels(typeResolver.resolve(Problem.class))
				.directModelSubstitute(Pageable.class, PageableModelOpenApi.class)
				.directModelSubstitute(Links.class, LinksModelOpenApi.class)
				.alternateTypeRules(AlternateTypeRules.newRule(
					    typeResolver.resolve(PagedModel.class, CozinhaModelV2.class),
					    CozinhasModelOpenApiV2.class))

					.alternateTypeRules(AlternateTypeRules.newRule(
					        typeResolver.resolve(CollectionModel.class, CidadeModelV2.class),
					        CidadesModelOpenApiV2.class))
				.apiInfo(apiInfoV2())
				.tags(new Tag("Cidades", "Gerenciar cidades"),
						new Tag("Cozinhas", "Gerenciar cozinhas"));
	}
	
	private List<ResponseMessage> globalGetResponseMessages() {
		return Arrays.asList(
				new ResponseMessageBuilder()
					.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.message("Erro interno do servidor")
					.responseModel(new ModelRef("Problema"))
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.NOT_ACCEPTABLE.value())
					.message("Recurso não possui representação que não poderia ser aceita pelo consumidor")
					.build()
		);
		
	}
	
	private List<ResponseMessage> globalPostPutResponseMessages() {
	    return Arrays.asList(
	            new ResponseMessageBuilder()
	                .code(HttpStatus.BAD_REQUEST.value())
	                .message("Requisição inválida (erro do cliente)")
	                .responseModel(new ModelRef("Problema"))
	                .build(),
	            new ResponseMessageBuilder()
	                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
	                .message("Erro interno no servidor")
	                .responseModel(new ModelRef("Problema"))
	                .build(),
	            new ResponseMessageBuilder()
	                .code(HttpStatus.NOT_ACCEPTABLE.value())
	                .message("Recurso não possui representação que poderia ser aceita pelo consumidor")
	                .build(),
	            new ResponseMessageBuilder()
	                .code(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
	                .message("Requisição recusada porque o corpo está em um formato não suportado")
	                .responseModel(new ModelRef("Problema"))
	                .build()
	        );
	}

	private List<ResponseMessage> globalDeleteResponseMessages() {
	    return Arrays.asList(
	            new ResponseMessageBuilder()
	                .code(HttpStatus.BAD_REQUEST.value())
	                .message("Requisição inválida (erro do cliente)")
	                .responseModel(new ModelRef("Problema"))
	                .build(),
	            new ResponseMessageBuilder()
	                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
	                .message("Erro interno no servidor")
	                .responseModel(new ModelRef("Problema"))
	                .build()
	        );
	}
	
	private ApiInfo apiInfoV1() {
		return new ApiInfoBuilder()
				.title("Algafood API (Depreciada)")
				.description("API Aberta para clientes e restaurantes. <br>"
						+ "<strong>Essa versão da API está depreciada e deixará de existir a partir de 01/01/2022</strong>")
				.version("1")
				.contact(new Contact("Algafood", "http://www.algafood.com.br", "contato@algafood.com.br"))
				.build();
	}
	
	private ApiInfo apiInfoV2() {
		return new ApiInfoBuilder()
				.title("Algafood API")
				.description("API Aberta para clientes e restaurantes")
				.version("2")
				.contact(new Contact("Algafood", "http://www.algafood.com.br", "contato@algafood.com.br"))
				.build();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
			.addResourceLocations("classpath:/META-INF/resources/");
		
		registry.addResourceHandler("/webjars/**")
			.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
}
