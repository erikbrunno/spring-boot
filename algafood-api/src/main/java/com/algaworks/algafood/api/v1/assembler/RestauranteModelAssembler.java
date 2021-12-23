package com.algaworks.algafood.api.v1.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.v1.AlgaLinks;
import com.algaworks.algafood.api.v1.controller.RestauranteController;
import com.algaworks.algafood.api.v1.model.RestauranteModel;
import com.algaworks.algafood.core.security.AlgaSecurity;
import com.algaworks.algafood.domain.model.Restaurante;

@Component
public class RestauranteModelAssembler extends RepresentationModelAssemblerSupport<Restaurante, RestauranteModel> {

	public RestauranteModelAssembler() {
		super(RestauranteController.class, RestauranteModel.class);
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AlgaLinks algaLinks;
	
	@Autowired
	private AlgaSecurity algaSecurity; 
	
	public RestauranteModel toModel(Restaurante restaurante) {
		RestauranteModel restauranteModel = createModelWithId(restaurante.getId(), restaurante);
		modelMapper.map(restaurante, restauranteModel);
	
		if (algaSecurity.podeConsultarRestaurantes()) {
			restauranteModel.add(algaLinks.linkToRestaurantes("restaurantes"));
		}
		
		
		if (restauranteModel.getCozinha() != null && algaSecurity.podeConsultarCozinhas()) {			
			restauranteModel.getCozinha().add(algaLinks.linkToCozinha(restauranteModel.getCozinha().getId()));
		}
		
		if (restauranteModel.getEndereco() != null && algaSecurity.podeConsultarCidades()) {
			restauranteModel.getEndereco().getCidade().add(algaLinks.linkToCidade(restauranteModel.getEndereco().getCidade().getId()));
		}
		
	    if (algaSecurity.podeConsultarRestaurantes()) {
	    	restauranteModel.add(algaLinks.linkToRestauranteFormasPagamento(restauranteModel.getId(), "formas-pagamento"));
	    }
		
	    if (algaSecurity.podeGerenciarCadastroRestaurantes()) {
	    	restauranteModel.add(algaLinks.linkToRestauranteResponsavel(restauranteModel.getId()));
	    }
	    
		
		 if (algaSecurity.podeGerenciarCadastroRestaurantes()) {
			 if (restaurante.ativacaoPermitida()) {
				 restauranteModel.add(
						 algaLinks.linkToRestauranteAtivacao(restaurante.getId(), "ativar"));
			 }
			 
			 if (restaurante.inativacaoPermitida()) {
				 restauranteModel.add(
						 algaLinks.linkToRestauranteInativacao(restaurante.getId(), "inativar"));
			 }
		 }

		 if (algaSecurity.podeGerenciarFuncionamentoRestaurantes(restaurante.getId())) {
			 if (restaurante.aberturaPermitida()) {
				 restauranteModel.add(
						 algaLinks.linkToRestauranteAbertura(restaurante.getId(), "abrir"));
			 }
			 
			 if (restaurante.fechamentoPermitido()) {
				 restauranteModel.add(
						 algaLinks.linkToRestauranteFechamento(restaurante.getId(), "fechar"));
			 }
		 }


		
		return restauranteModel;
	}

	public List<RestauranteModel> toCollectionModel(List<Restaurante> restaurantes) {
		return restaurantes.stream().map(restaurante -> toModel(restaurante)).collect(Collectors.toList());
	}

}
