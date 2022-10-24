package com.portfolio.thot.project.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.portfolio.thot.project.dto.UserDTO;
import com.portfolio.thot.project.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	public User map(UserDTO userDTO);
	
	public UserDTO mapToDTO(User user);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	public void updateUserFromDTO(UserDTO dto, @MappingTarget User user);
	
}
