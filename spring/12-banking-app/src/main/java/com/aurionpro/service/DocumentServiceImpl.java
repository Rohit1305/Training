package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.model.Document;
import com.aurionpro.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService{
	@Autowired
    private DocumentRepository documentRepository;
	

	public DocumentServiceImpl(DocumentRepository documentRepository) {
		super();
		this.documentRepository = documentRepository;
	}

	@Override
	public List<Document> findByCustomer(int customerId) {
		return documentRepository.findAll();
	}
	
	

}
