package com.project.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.api.models.User;
import com.project.api.models.exceptions.RegisterNotFoundException;
import com.project.api.repositories.UserRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User getById(Long id) throws RegisterNotFoundException{
		Optional<User> optUser = repository.findById(id);
		if (optUser.isEmpty()) {
			log.info("Não foi possível encontrar o usuario de id "+id);
			throw new RegisterNotFoundException();
		}
		log.info("Buscando o usuario de id "+id);
		return optUser.get();
	}
	
	
//	public User login(User user) throws RegisterNotFoundException {
//		
//	}
}
