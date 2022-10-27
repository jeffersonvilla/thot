package com.portfolio.thot.project.service;

import java.util.UUID;

import com.portfolio.thot.project.dto.LibroDTO;

public interface LibroServiceInterface {

	public void save(LibroDTO libro);
	
	public LibroDTO getLibroById(UUID libroId) throws Exception;
	
	public void updateLibro(LibroDTO libro) throws Exception;
	
	public void deleteLibroById(UUID libroId);
}
