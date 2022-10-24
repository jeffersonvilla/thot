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

import com.portfolio.thot.project.dto.UserDTO;
import com.portfolio.thot.project.service.UserService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/user/")
@AllArgsConstructor
public class UserController {

	private UserService userService;


	@GetMapping("/get/id/{userId}")
	public ResponseEntity<UserDTO> getUser(@PathVariable String userId) throws Exception{
		UserDTO user = userService.getUserByUserId(UUID.fromString(userId));
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Void> saveUser(@RequestBody UserDTO user) {
		userService.saveUser(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Void> updateUser(@RequestBody UserDTO user) throws Exception{
		userService.updateUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/id/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId){
		userService.deleteUserByUserId(UUID.fromString(userId));
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
