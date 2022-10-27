package com.portfolio.thot.project.service;

import java.util.UUID;

import com.portfolio.thot.project.dto.EjemplarDTO;

public interface EjemplarServiceInterface {

	public void save(EjemplarDTO ejemplarDTO) throws Exception;
	
	public EjemplarDTO getEjemplarById(UUID ejemplarId) throws Exception;
	
	public void updateEjemplar(EjemplarDTO ejemplar) throws Exception;
	
	public void deleteEjemplarById(UUID ejemplarId);
	
}
