package com.example.apiChat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiChat.models.User;
import com.example.apiChat.repositories.FriendshipRepository;
import com.example.apiChat.repositories.UserRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class FriendshipService {

	@Autowired
	private FriendshipRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllFriends(Long userId) {
		return repository.findByUsuarioId(userId);
	}
}
