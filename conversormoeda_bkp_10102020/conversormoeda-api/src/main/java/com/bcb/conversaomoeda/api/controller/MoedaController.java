package com.bcb.conversaomoeda.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcb.conversaomoeda.api.assembler.MoedaModelAssembler;
import com.bcb.conversaomoeda.api.model.MoedaModel;
import com.bcb.conversaomoeda.domain.model.Moeda;
import com.bcb.conversaomoeda.domain.service.CadastroMoedaService;

@RestController
@RequestMapping("/moedas")
public class MoedaController {
	
	@Autowired
	private CadastroMoedaService cadastroMoeda;
	
	@Autowired
	private MoedaModelAssembler moedaModelAssembler;
	
	@GetMapping
	public List<MoedaModel> listar() {
		
		List<Moeda> todasMoedas = cadastroMoeda.consultar();
		return moedaModelAssembler.toCollectionModel(todasMoedas);
	}
}
