package com.example.apiChat.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiChat.models.User;
import com.example.apiChat.models.exceptions.RegisterNotFoundException;
import com.example.apiChat.repositories.UserRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> getAll() {
		return repository.findAll();
	}
	
	public User getById(Long id) throws RegisterNotFoundException{
		Optional<User> optUser = repository.findById(id);
		if (optUser.isEmpty()) {
			log.info("Não foi possível encontrar o usuario de id "+id);
			throw new RegisterNotFoundException();
		}
		log.info("Buscando o usuario de id "+id);
		return optUser.get();
	}
	
	public User save(User user) {
		log.info("Salvando novo usuario...");
		return repository.saveAndFlush(user);
	}
	
	public User update(User user) throws RegisterNotFoundException {
		User _user = this.getById(user.getId());
		_user.setUsername(user.getUsername());
		_user.setPhoto(user.getPhoto());
		_user.setFriendCode(user.getFriendCode());
		_user.setLastTimeOnline(user.getLastTimeOnline());
		return repository.saveAndFlush(_user);
	}
	
	public User updateLastTimeOnline(Long id) throws RegisterNotFoundException {
		User _user = this.getById(id);
		_user.setLastTimeOnline(LocalDateTime.now());
		return this.update(_user);
	}
	
	public User deleteById(Long id) throws RegisterNotFoundException {
		User user = this.getById(id);
		repository.delete(user);
		return user;
	}
}
