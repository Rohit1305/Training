package com.aurionpro.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.model.Customer;
import com.aurionpro.model.Document;
import com.aurionpro.service.DocumentService;

@RestController
@RequestMapping("/document")
public class DocumentController {
	private DocumentService service;

	public DocumentController(DocumentService service) {
		super();
		this.service = service;
	}
	@GetMapping("/findByCustomer")
	 public ResponseEntity<List<Document>> findByCustomer(@PathVariable int customerId) {
		List <Document> documentList=service.findByCustomer(customerId);
		return new ResponseEntity<>(documentList,HttpStatus.OK);
		
	}
	
	

}
