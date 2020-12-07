package com.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.api.models.FriendshipRequest;

public interface FriendshipRequestRepository extends JpaRepository<FriendshipRequest, Long>{

}
