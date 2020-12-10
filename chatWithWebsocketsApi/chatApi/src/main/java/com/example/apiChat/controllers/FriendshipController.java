package com.example.apiChat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiChat.models.User;
import com.example.apiChat.services.FriendshipService;

@RestController
@RequestMapping(path = "/friendship")
public class FriendshipController {

	@Autowired
	private FriendshipService service;
	
	@CrossOrigin("*")
	@GetMapping("/friends/{userId}")
	public ResponseEntity<List<User>> getAllFriends(@PathVariable("userId") Long userId) {
		return ResponseEntity.ok(service.getAllFriends(userId));
	}
	
}
