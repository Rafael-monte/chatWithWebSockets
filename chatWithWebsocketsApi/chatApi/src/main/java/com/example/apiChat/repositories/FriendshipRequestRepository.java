package com.example.apiChat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiChat.models.FriendshipRequest;

public interface FriendshipRequestRepository extends JpaRepository<FriendshipRequest, Long>{

}
