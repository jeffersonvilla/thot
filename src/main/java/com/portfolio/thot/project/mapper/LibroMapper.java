package com.portfolio.thot.project.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.portfolio.thot.project.dto.LibroDTO;
import com.portfolio.thot.project.model.Libro;

@Mapper(componentModel = "spring")
public interface LibroMapper {
	
	public Libro map(LibroDTO dto);
	
	public LibroDTO mapToDTO(Libro libro);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	public void updateLibroFromDTO(LibroDTO DTO, @MappingTarget Libro libro);

}
