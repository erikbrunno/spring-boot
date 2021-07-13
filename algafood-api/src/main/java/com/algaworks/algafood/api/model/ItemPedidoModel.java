package com.algaworks.algafood.api.model;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "itensPedidos")
@Getter
@Setter
public class ItemPedidoModel extends RepresentationModel<ItemPedidoModel>{

	@ApiModelProperty(value = "ID do produto", example = "1")
    private Long produtoId;
	
	@ApiModelProperty(value = "Nome do produto", example = "barbeador")
    private String produtoNome;
	
	@ApiModelProperty(value = "quantidade do produto", example = "1")
    private Integer quantidade;
	
	@ApiModelProperty(value = "Preco unitário do produto", example = "10")
    private BigDecimal precoUnitario;
	
	@ApiModelProperty(value = "Preço total do produto", example = "10")
    private BigDecimal precoTotal;
	
	@ApiModelProperty(value = "Observação")
    private String observacao;            
} 