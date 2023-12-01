package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer>{

}
