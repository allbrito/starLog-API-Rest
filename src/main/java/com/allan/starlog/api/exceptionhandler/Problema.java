package com.allan.starlog.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@Getter 
@AllArgsConstructor
public class Problema {

	private Integer status;
	private OffsetDateTime dataHora;
	private String mensagem;
	private List<Campo> campos;
	
	public Problema(Integer status, OffsetDateTime dataHora, String mensagem) {
		
		this.status = status;
		this.dataHora = dataHora;
		this.mensagem = mensagem;
	}
}
