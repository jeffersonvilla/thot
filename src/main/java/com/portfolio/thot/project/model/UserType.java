package com.portfolio.thot.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserType {
	@JsonProperty("admin")
	ADMIN,
	@JsonProperty("bibliotecario")
	BIBLIOTECARIO,
	@JsonProperty("estudiante")
	ESTUDIANTE;
	
	
}
