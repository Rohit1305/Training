package com.aurionpro.service;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.aurionpro.model.Customer;
import com.aurionpro.model.Document;
import com.aurionpro.payload.CustomerRegistorDto;
import com.aurionpro.payload.LoginDto;

public interface CustomerService {

	List<Customer> findAll();

	Customer save(Customer customer);

	Customer registerCustomer(CustomerRegistorDto customerDto);

	Customer customerLogin(LoginDto loginDto);

//	Document uploadFile(MultipartFile file) throws IOException;
//
//	public ResponseEntity<ByteArrayResource> downloadFile(int id);
//
//	String accountCreationRequest(int bankId, int customerId, List<MultipartFile> files);

	

}
