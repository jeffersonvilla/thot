package com.portfolio.thot.project.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.portfolio.thot.project.dto.EjemplarDTO;
import com.portfolio.thot.project.model.Ejemplar;
import com.portfolio.thot.project.model.Libro;

@Mapper(componentModel = "spring")
public interface EjemplarMapper {

	@Mapping(target = "libro", source = "libro")
	public Ejemplar map(EjemplarDTO ejemplar, Libro libro);
	
	@Mapping(target = "libroId", expression = "java(ejemplar.getLibro().getLibroId())")
	public EjemplarDTO mapToDTO(Ejemplar ejemplar);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "libro", source = "libro")
	public void updateEjemplarFromDTO(EjemplarDTO dto, Libro libro, @MappingTarget Ejemplar ejemplar);
	
}
