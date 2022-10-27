package com.portfolio.thot.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EstadoEjemplar {
	@JsonProperty("disponible")
	DISPONIBLE,
	@JsonProperty("prestado")
	PRESTADO,
	@JsonProperty("reservado")
	RESERVADO;
	
}
