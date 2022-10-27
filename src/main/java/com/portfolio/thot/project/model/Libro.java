package com.portfolio.thot.project.model;


import java.util.UUID;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="libro")
@Builder
public class Libro {
	
	@Id
	@Type(type = "uuid-char")
	private final UUID libroId = UUID.randomUUID();
	@NotBlank
	private String titulo;
	@NotNull
	private int cantidadTotalEjemplares;
	@NotNull
	private int cantidadEjemplaresDisponible;
	
	
}
