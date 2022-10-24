package com.portfolio.thot.project.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.portfolio.thot.project.model.User;
import com.portfolio.thot.project.repo.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOptional = userRepo.findByUsername(username);
		User user = userOptional.orElseThrow(()-> new UsernameNotFoundException("No existe usuario con username: "+username));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), null);
	}

}
