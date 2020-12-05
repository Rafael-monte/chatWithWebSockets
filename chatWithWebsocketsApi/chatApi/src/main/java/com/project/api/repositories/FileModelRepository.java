package com.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.api.models.FileModel;

public interface FileModelRepository extends JpaRepository<FileModel , Long>{

}
