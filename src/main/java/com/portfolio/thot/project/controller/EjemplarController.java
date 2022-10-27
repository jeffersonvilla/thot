package com.portfolio.thot.project.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.thot.project.dto.EjemplarDTO;
import com.portfolio.thot.project.service.EjemplarService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/ejemplar/")
@AllArgsConstructor
public class EjemplarController {

	private EjemplarService ejemplarService;
	
	@PostMapping("/save")
	public ResponseEntity<Void> save(@RequestBody EjemplarDTO ejemplar) throws Exception{
		ejemplarService.save(ejemplar);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/get/id/{ejemplarId}")
	public ResponseEntity<EjemplarDTO> getEjemplarById(@PathVariable String ejemplarId) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(ejemplarService.getEjemplarById(UUID.fromString(ejemplarId)));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Void> updateEjemplar(@RequestBody EjemplarDTO ejemplar) throws Exception{
		ejemplarService.updateEjemplar(ejemplar);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/id/{ejemplarId}")
	public ResponseEntity<Void> deleteEjemplarById(@PathVariable String ejemplarId){
		ejemplarService.deleteEjemplarById(UUID.fromString(ejemplarId));
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
