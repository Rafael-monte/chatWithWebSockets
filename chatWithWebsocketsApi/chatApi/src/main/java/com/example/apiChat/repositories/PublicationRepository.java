package com.example.apiChat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiChat.models.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long>{

}
