package com.portfolio.thot.project.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Ejemplar {

	@Id
	@Type(type = "uuid-char")
	private final UUID ejemplarId = UUID.randomUUID();
	private EstadoEjemplar estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "libroId", nullable = false)
	private Libro libro;
}
