package com.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.api.models.Friendship;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

}
