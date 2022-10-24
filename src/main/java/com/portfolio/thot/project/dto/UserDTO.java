package com.portfolio.thot.project.dto;

import java.util.UUID;

import com.portfolio.thot.project.model.UserType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
	private UUID userId;
	private String username;
	private String password;
	private UserType tipoUsuario;
}
