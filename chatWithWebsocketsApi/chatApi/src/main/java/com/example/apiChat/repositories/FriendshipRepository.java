package com.example.apiChat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiChat.models.Friendship;
import com.example.apiChat.models.User;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

	List<User> findByUsuarioId(Long userId);

}
