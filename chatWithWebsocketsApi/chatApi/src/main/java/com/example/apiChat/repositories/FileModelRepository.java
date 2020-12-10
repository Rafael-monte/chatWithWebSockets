package com.example.apiChat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiChat.models.FileModel;

public interface FileModelRepository extends JpaRepository<FileModel , Long>{

}
