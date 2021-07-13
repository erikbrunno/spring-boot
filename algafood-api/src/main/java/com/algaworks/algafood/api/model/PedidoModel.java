package com.algaworks.algafood.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
@Relation(collectionRelation = "pedidos")
@Setter
@Getter
public class PedidoModel extends RepresentationModel<PedidoModel> {

	@ApiModelProperty(value = "Codigo do pedido", example = "1")
    private String codigo;
	
	@ApiModelProperty(value = "subtotal do pedido", example = "10")
    private BigDecimal subtotal;
	
	@ApiModelProperty(value = "Taxa frete do pedido", example = "5")
    private BigDecimal taxaFrete;
	
	@ApiModelProperty(value="valor total do pedido", example = "15")
    private BigDecimal valorTotal;
	
	@ApiModelProperty(value="statudo do pedido", example = "CONFIRMADO")
    private String status;
	
	@ApiModelProperty(value = "Data de criação do pedido")
    private OffsetDateTime dataCriacao;
	
	@ApiModelProperty(value = "Data de confirmação do pedido")
    private OffsetDateTime dataConfirmacao;
	
	@ApiModelProperty(value = "Data de entrega do pedido")
    private OffsetDateTime dataEntrega;
	
	@ApiModelProperty(value = "Data de cancelamento do pedido")
    private OffsetDateTime dataCancelamento;
	
	@ApiModelProperty(value = "Restaurante do pedido realizado", example = "Restaurante arretado de bom")
    private RestauranteResumoModel restaurante;
	
	@ApiModelProperty(value = "Cliente que realizou o pedido", example = "Erik Brunno")
    private UsuarioModel cliente;
	
	@ApiModelProperty(value = "Forma de pagamento selecionada", example = "Cartão de credito")
    private FormaPagamentoModel formaPagamento;
	
	@ApiModelProperty(value = "Endereço de entrega do pedido")
    private EnderecoModel enderecoEntrega;
	
	@ApiModelProperty(value = "Itens do pedido")
    private List<ItemPedidoModel> itens;   
}  