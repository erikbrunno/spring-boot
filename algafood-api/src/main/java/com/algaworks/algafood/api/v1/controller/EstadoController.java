package com.algaworks.algafood.api.v1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.v1.assembler.EstadoInputDisassembler;
import com.algaworks.algafood.api.v1.assembler.EstadoModelAssembler;
import com.algaworks.algafood.api.v1.model.EstadoModel;
import com.algaworks.algafood.api.v1.model.input.EstadoInput;
import com.algaworks.algafood.api.v1.openapi.controller.EstadosControllerOpenApi;
import com.algaworks.algafood.core.security.CheckSecurity;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.CadastroEstadoService;

@RestController
@RequestMapping(path = "/v1/estados", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstadoController implements EstadosControllerOpenApi {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CadastroEstadoService cadastroEstadoService;
	
	@Autowired
	private EstadoModelAssembler estadoModelAssembler;
	
	@Autowired
	private EstadoInputDisassembler estadoInputDisassembler;
	
	@CheckSecurity.Estados.PodeConsultar
	@GetMapping
	public CollectionModel<EstadoModel> listar() {
		List<Estado> todosEstados = estadoRepository.findAll();
		return estadoModelAssembler.toCollectionModel(todosEstados);
	}
	
	@CheckSecurity.Estados.PodeConsultar
	@GetMapping("/{estadoId}")
	public EstadoModel buscar(@PathVariable Long estadoId) {
		Estado estadoEncontrado = cadastroEstadoService.buscar(estadoId); 
		return estadoModelAssembler.toModel(estadoEncontrado);
	}
	
	@CheckSecurity.Estados.PodeEditar
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EstadoModel adicionar(@RequestBody @Valid EstadoInput estadoInput) {
		Estado estado = estadoInputDisassembler.toDomainObject(estadoInput);
		estado = cadastroEstadoService.salvar(estado);
		return estadoModelAssembler.toModel(estado) ;
	}
	
	@CheckSecurity.Estados.PodeEditar
	@PutMapping("/{estadoId}")
	public EstadoModel atualizar(@PathVariable Long estadoId, @Valid @RequestBody EstadoInput estadoInput) {
		Estado estadoAtual = cadastroEstadoService.buscar(estadoId);
		estadoInputDisassembler.copyToDomainObject(estadoInput, estadoAtual);
		estadoAtual = cadastroEstadoService.salvar(estadoAtual);
		return estadoModelAssembler.toModel(estadoAtual);
	}
	
	@CheckSecurity.Estados.PodeEditar
	@DeleteMapping("/{estadoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long estadoId) {
		cadastroEstadoService.excluir(estadoId);
	}

}
