package com.example.apiChat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiChat.models.Friendship;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

}
