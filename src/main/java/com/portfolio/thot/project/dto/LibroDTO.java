package com.portfolio.thot.project.dto;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibroDTO {
	
	private UUID libroId;
	private String titulo;
	private int cantidadTotalEjemplares;
	private int cantidadEjemplaresDisponible;
}
