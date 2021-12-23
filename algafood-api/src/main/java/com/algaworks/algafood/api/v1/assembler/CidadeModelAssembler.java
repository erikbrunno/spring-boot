package com.algaworks.algafood.api.v1.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.v1.AlgaLinks;
import com.algaworks.algafood.api.v1.controller.CidadeController;
import com.algaworks.algafood.api.v1.model.CidadeModel;
import com.algaworks.algafood.core.security.AlgaSecurity;
import com.algaworks.algafood.domain.model.Cidade;


@Component
public class CidadeModelAssembler extends RepresentationModelAssemblerSupport<Cidade, CidadeModel> {

	public CidadeModelAssembler() {
		super(CidadeController.class, CidadeModel.class);
	}

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AlgaLinks algaLinks;
	
	@Autowired
	private AlgaSecurity algaSecurity;
	
	@Override
	public CidadeModel toModel(Cidade cidade) {
//		CidadeModel cidadeModel = modelMapper.map(cidade, CidadeModel.class);
//		cidadeModel.add(linkTo(methodOn(CidadeController.class)
//				.buscar(cidadeModel.getId())).withSelfRel());
		
		//Instancia o cidadeModel e ja inclui o link Self
		CidadeModel cidadeModel = createModelWithId(cidade.getId(), cidade);
		//Copia tudo de cidade para cidadeModel
		modelMapper.map(cidade, cidadeModel);
		
		if (algaSecurity.podeConsultarCidades()) {
			cidadeModel.add(algaLinks.linkToCidades());
		}
		
		if (algaSecurity.podeConsultarEstados()) {
			cidadeModel.getEstado().add(algaLinks.linkToEstado(cidadeModel.getEstado().getId()));
			cidadeModel.getEstado().add(algaLinks.linkToEstados());
		}
		
		
		return cidadeModel;
	}

	@Override
	public CollectionModel<CidadeModel> toCollectionModel(Iterable<? extends Cidade> entities) {
		 CollectionModel<CidadeModel> collectionModel = super.toCollectionModel(entities);
		 
		 if (algaSecurity.podeConsultarCidades()) {
			 collectionModel.add(linkTo(CidadeController.class).withSelfRel());
		 }
		 
		 return collectionModel;
	}
	
	

}
