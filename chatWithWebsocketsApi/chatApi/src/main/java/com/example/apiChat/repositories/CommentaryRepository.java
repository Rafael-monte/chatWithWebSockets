package com.example.apiChat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiChat.models.Commentary;

public interface CommentaryRepository extends JpaRepository<Commentary, Long> {

}
