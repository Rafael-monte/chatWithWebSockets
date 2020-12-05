package com.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.api.models.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long>{

}
