package com.example.apiChat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiChat.models.User;
import com.example.apiChat.models.exceptions.InvalidPasswordException;
import com.example.apiChat.models.exceptions.RegisterNotFoundException;
import com.example.apiChat.models.exceptions.UsuarioDuplicadoException;
import com.example.apiChat.services.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@CrossOrigin("*")
	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/{id}")
	public ResponseEntity<User> getById(@PathVariable("id") Long id) throws RegisterNotFoundException {
		return ResponseEntity.ok(service.getById(id));
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> save(@RequestBody User user) throws UsuarioDuplicadoException {
		return ResponseEntity.ok(service.save(user));
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path="/login")
	public ResponseEntity<User> login(@RequestBody User user) throws InvalidPasswordException, RegisterNotFoundException {
		return ResponseEntity.ok(service.login(user));
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> update(@RequestBody User user) throws RegisterNotFoundException {
		return ResponseEntity.ok(service.update(user));
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<User> deleteById(@PathVariable("id") Long id) throws RegisterNotFoundException {
		return ResponseEntity.ok(service.deleteById(id));
	}
}
