package com.example.apiChat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiChat.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
