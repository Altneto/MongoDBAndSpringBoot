package com.altneto.springMongo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altneto.springMongo.domain.Post;
import com.altneto.springMongo.domain.User;
import com.altneto.springMongo.dto.UserDto;
import com.altneto.springMongo.repositories.UserRepository;
import com.altneto.springMongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<UserDto> findAll() {
		List<User> users = userRepository.findAll();
		List<UserDto> dtos = users.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
		return dtos;
	}
	
	public UserDto findById(String id) {
		Optional<User> user = userRepository.findById(id);
		
		if (!user.isPresent()) {
			throw new ObjectNotFoundException("Usuário não encontrado");
		}
		
		return new UserDto(user.get());	
	}
	
	public List<Post> findPosts(String id) {
		Optional<User> user = userRepository.findById(id);
		
		if (!user.isPresent()) {
			throw new ObjectNotFoundException("Usuário não encontrado");
		}
		
		return user.get().getPosts();
	}
	
	public User save(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);	
	}
	
	public User update(User newObj) {
		Optional<User> obj = userRepository.findById(newObj.getId());
		
		if (!obj.isPresent()) {
			throw new ObjectNotFoundException("Usuário não encontrado");	
		}
		
		updateData(obj.get(), newObj);
		
		return userRepository.save(obj.get());
	}

	private void updateData(User obj, User newObj) {
		obj.setName(newObj.getName());
		obj.setEmail(newObj.getEmail());
	}
}
