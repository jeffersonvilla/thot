package com.portfolio.thot.project.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

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
public class User {

	@Id
	@Type(type = "uuid-char")
	private final UUID userId = UUID.randomUUID();
	@NotBlank(message = "Es necesario el nombre de usuario")
	private String username;
	@NotBlank(message = "Es necesario la contraseña")
	private String password;
	private UserType tipoUsuario;

}
