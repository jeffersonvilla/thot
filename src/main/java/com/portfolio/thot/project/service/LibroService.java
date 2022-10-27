package com.portfolio.thot.project.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.portfolio.thot.project.dto.LibroDTO;
import com.portfolio.thot.project.mapper.LibroMapper;
import com.portfolio.thot.project.model.Libro;
import com.portfolio.thot.project.repo.LibroRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class LibroService implements LibroServiceInterface {

	private LibroRepository libroRepo;
	
	private final LibroMapper mapper;
	
	@Override
	public void save(LibroDTO libro) {
		Libro lib = Libro.builder()
				.titulo(libro.getTitulo())
				.cantidadTotalEjemplares(libro.getCantidadTotalEjemplares())
				.cantidadEjemplaresDisponible(libro.getCantidadEjemplaresDisponible())
				.build();
		libroRepo.save(lib);
	}

	@Override
	public LibroDTO getLibroById(UUID libroId) throws Exception {
		Libro libro = libroRepo.findById(libroId).orElseThrow(()->new Exception("No se encuentra el libro con libroId: "+libroId));
		return mapper.mapToDTO(libro);
	}

	@Override
	public void updateLibro(LibroDTO libro) throws Exception {
		Libro lib = libroRepo.findById(libro.getLibroId()).orElseThrow(()->new Exception("No se encuentra el libro con libroId: "+libro.getLibroId()));
		mapper.updateLibroFromDTO(libro, lib);
		libroRepo.save(lib);
	}

	@Override
	public void deleteLibroById(UUID libroId) {
		libroRepo.deleteById(libroId);
	}

}
