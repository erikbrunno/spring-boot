/*
 * Representa o corpo do erro de uma exceção seguindo 
 * o formato definido na especificação RFC 7807 (Problems Details for HTTP APIs)
*/
package com.algaworks.algafood.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@ApiModel("Problema")
@JsonInclude(Include.NON_NULL)
@Getter
@Builder
public class Problem {
		
	/**
	 * Esses atributos de problema são definido com base na especificação
	 * Problem Details for HTTP APIs
	 */
	@ApiModelProperty(example = "400", position = 1)
	private Integer status;
	
	@ApiModelProperty(example = "http://localhost//dados-invalidos",  position = 5)
	private String type;
	
	@ApiModelProperty(example = "Dados inválidos",  position = 10)
	private String title;
	
	@ApiModelProperty(example = "Um ou mais campos são obrigátorios", position = 15)
	private String detail;
	
	private String userMessage;
	
	@ApiModelProperty(example = "2021-03-29T23:15:28.1730077Z", position = 20)
	private OffsetDateTime timestamp;
	
	@ApiModelProperty(position = 25)
	private List<Object> objects;

	@ApiModel("ObjetoProblema")
	@Getter
	@Builder
	public static class Object {
		private String name;
		private String userMessage;
	}
}
