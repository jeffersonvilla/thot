package com.portfolio.thot.project.dto;

import java.util.UUID;

import com.portfolio.thot.project.model.EstadoEjemplar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EjemplarDTO {

	private UUID ejemplarId;
	private EstadoEjemplar estado;
	private UUID libroId;
}
