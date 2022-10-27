package com.portfolio.thot.project.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.portfolio.thot.project.dto.EjemplarDTO;
import com.portfolio.thot.project.mapper.EjemplarMapper;
import com.portfolio.thot.project.model.Ejemplar;
import com.portfolio.thot.project.model.Libro;
import com.portfolio.thot.project.repo.EjemplarRespository;
import com.portfolio.thot.project.repo.LibroRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class EjemplarService implements EjemplarServiceInterface {

	private EjemplarRespository ejemplarRepo;
	
	private LibroRepository libroRepo;

	private EjemplarMapper mapper;
	
	@Override
	public void save(EjemplarDTO ejemplarDTO) throws Exception {
		Libro libro = libroRepo.findById(ejemplarDTO.getLibroId())
				.orElseThrow(()->new Exception("Libro con libroId: "+ ejemplarDTO.getLibroId()+" no encontrado."));
		ejemplarRepo.save(mapper.map(ejemplarDTO, libro));
	}

	@Override
	public EjemplarDTO getEjemplarById(UUID ejemplarId) throws Exception {
		Ejemplar ejemplar = ejemplarRepo.findById(ejemplarId)
				.orElseThrow(()->new Exception("No ejemplar encontrado con ejemplarId: "+ ejemplarId));
		return mapper.mapToDTO(ejemplar);
	}

	@Override
	public void updateEjemplar(EjemplarDTO ejemplar) throws Exception {
		Ejemplar ej = ejemplarRepo.findById(ejemplar.getEjemplarId())
				.orElseThrow(()->new Exception("No ejemplar encontrado con ejemplarId: "+ ejemplar.getEjemplarId()));
		Libro libro = libroRepo.findById(ej.getLibro().getLibroId())
				.orElseThrow(()-> new Exception("Libro con libroId: "+ ej.getLibro().getLibroId()+" no encontrado."));
		mapper.updateEjemplarFromDTO(ejemplar,libro, ej);
		ejemplarRepo.save(ej);
	}

	@Override
	public void deleteEjemplarById(UUID ejemplarId) {
		ejemplarRepo.deleteById(ejemplarId);
	}

}
