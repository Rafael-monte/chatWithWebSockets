package com.example.apiChat.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiChat.models.User;
import com.example.apiChat.models.exceptions.InvalidPasswordException;
import com.example.apiChat.models.exceptions.RegisterNotFoundException;
import com.example.apiChat.models.exceptions.UsuarioDuplicadoException;
import com.example.apiChat.repositories.UserRepository;
import com.example.apiChat.utils.PasswordUtils;

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
	
	public User login(User user) throws RegisterNotFoundException, InvalidPasswordException {
		Optional<User> optUser = repository.findByEmail(user.getEmail());
		if (optUser.isEmpty()) {
			throw new RegisterNotFoundException();
		}
		User _foundUser = optUser.get();
		if (!this.isPasswordValid(_foundUser, user)) {
			throw new InvalidPasswordException();
		}
		return optUser.get();
	}

	public boolean isPasswordValid(User _foundUser, User user) {
		boolean isValid = PasswordUtils.verifyUserPassword(user.getPassword(), _foundUser.getPassword(), _foundUser.getSalt());
		return isValid;
	}

	public User save(User user) throws UsuarioDuplicadoException {
		log.info("Salvando novo usuario...");
		Optional<User> optUser = this.repository.findByEmail(user.getEmail());
		if (optUser.isPresent()) {
			throw new UsuarioDuplicadoException();
		}
		this.encryptUserPassword(user);
		user.setFriendCode(this.createFriendCode(user));
		return repository.saveAndFlush(user);
	}
	
	public User encryptUserPassword(User user) {
		String salt = PasswordUtils.getSalt(30);
		user.setSalt(salt);
		String newSecurePassword = PasswordUtils.generateSecurePassword(user.getPassword(), salt);
		user.setPassword(newSecurePassword);
		return user;
	}

	public String createFriendCode(User user) {
		LocalDate dataAtual = LocalDate.now();
		String friendCode = "U"+"/"+user.getId()+dataAtual.getYear()+"#";
		return friendCode;
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
