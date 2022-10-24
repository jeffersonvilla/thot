package com.portfolio.thot.project.service;

import java.util.UUID;

import com.portfolio.thot.project.dto.UserDTO;


public interface UserServiceInterface {

	public void saveUser(UserDTO user);
	
	public UserDTO getUserByUserId(UUID userId) throws Exception;
	
	public void updateUser(UserDTO user) throws Exception;
	
	public void deleteUserByUserId(UUID userId);
	
}
