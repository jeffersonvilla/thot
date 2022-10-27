package com.portfolio.thot.project.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.thot.project.dto.LibroDTO;
import com.portfolio.thot.project.service.LibroService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/libro/")
@AllArgsConstructor
public class LibroController {
	
	private LibroService libroService;
	
	@PostMapping("/save")
	public ResponseEntity<Void> saveLibro(@RequestBody LibroDTO libro){
		libroService.save(libro);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/get/id/{libroId}")
	public ResponseEntity<LibroDTO> getLibroById(@PathVariable String libroId) throws Exception{
		LibroDTO libro = libroService.getLibroById(UUID.fromString(libroId));
		return ResponseEntity.status(HttpStatus.OK).body(libro);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Void> updateLibro(@RequestBody LibroDTO libro) throws Exception{
		libroService.updateLibro(libro);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/id/{libroId}")
	public ResponseEntity<Void> deleteLibroById(@PathVariable String libroId){
		libroService.deleteLibroById(UUID.fromString(libroId));
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
