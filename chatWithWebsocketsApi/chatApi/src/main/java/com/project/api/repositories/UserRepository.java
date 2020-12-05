package com.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.api.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
