package com.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.api.models.Commentary;

public interface CommentaryRepository extends JpaRepository<Commentary, Long> {

}
