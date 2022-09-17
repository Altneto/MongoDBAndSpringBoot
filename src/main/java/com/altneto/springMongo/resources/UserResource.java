package com.altneto.springMongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.altneto.springMongo.dto.UserDto;
import com.altneto.springMongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>> findAll() {
		List<UserDto> dtos = userService.findAll();
		return ResponseEntity.ok().body(dtos);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDto> FindById(@PathVariable String id) {
		UserDto dto = userService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
