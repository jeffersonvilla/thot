package com.portfolio.thot.project.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.portfolio.thot.project.dto.UserDTO;
import com.portfolio.thot.project.mapper.UserMapper;
import com.portfolio.thot.project.model.User;
import com.portfolio.thot.project.repo.UserRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
@Transactional
public class UserService implements UserServiceInterface{

	private UserRepository userRepository;
	
	private PasswordEncoder passwordEncoder;
	
	private final UserMapper userMapper;
	
	@Override
	public void saveUser(UserDTO user) {
		User u = User.builder()
				.username(user.getUsername())
				.password(passwordEncoder.encode(user.getPassword()))
				.tipoUsuario(user.getTipoUsuario())
				.build();
		userRepository.save(u);
	}

	@Override
	public UserDTO getUserByUserId(UUID userId) throws Exception {
		User user = userRepository.findById(userId)
				.orElseThrow(()->new Exception("Usuario con userId: "+userId+" no encontrado."));
		return userMapper.mapToDTO(user);
	}

	@Override
	public void deleteUserByUserId(UUID userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public void updateUser(UserDTO user) throws Exception {
		User u = userRepository.findById(user.getUserId())
				.orElseThrow(()->new Exception("Usuario con userId: "+user.getUserId()+" no encontrado."));
		userMapper.updateUserFromDTO(user, u);
		if(!user.getPassword().startsWith("$2a$") && user.getPassword().length()!=60)
			u.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(u);
	}

}
