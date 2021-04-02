package com.algaworks.algafood.domain.model.filter;

import java.time.OffsetDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PedidoFilter {

	@ApiModelProperty(value = "ID do cliente", example = "1")
	private Long clienteId;
	
	@ApiModelProperty(value = "ID do restaurante", example = "1")
	private Long restauranteId;
	
	@ApiModelProperty(value= "data inicio", example = "2000-10-31T01:30:00.000-05:00")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private OffsetDateTime dataCriacaoInicio;
	
	@ApiModelProperty(value= "data fim", example = "2000-11-30T01:30:00.000-05:00")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private OffsetDateTime dataCriacaoFim;
}
