package com.aurionpro.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aurionpro.model.Customer;
import com.aurionpro.model.Document;
import com.aurionpro.payload.CustomerRegistorDto;
import com.aurionpro.payload.LoginDto;
import com.aurionpro.repository.DocumentRepository;
import com.aurionpro.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllcustomer() {
		List<Customer> customerList = customerService.findAll();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

	@PutMapping("/customer")
	public ResponseEntity<Customer> updatecustomer(@RequestBody Customer customer) {
		Customer customerToAdd = customerService.save(customer);
		return new ResponseEntity<>(customerToAdd, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	 public ResponseEntity<Customer> registerCustomer(@RequestBody CustomerRegistorDto customerDto){
	  Customer customerToAdd =customerService.registerCustomer(customerDto);
	  return new ResponseEntity<>(customerToAdd,HttpStatus.CREATED);
	 }
	
	@PostMapping("/login")
	 public ResponseEntity<Customer> customerLogin(@RequestBody LoginDto loginDto) {
	     Customer customer = customerService.customerLogin(loginDto);
	     if (customer != null) {
	         return new ResponseEntity<>(customer, HttpStatus.OK);
	     } else {
	         return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	     }
	 }


//	//  UPLOAD AND DOWNLOAD
//	@PostMapping("/upload")
//	public ResponseEntity<Document> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
//		customerService.uploadFile(file);
//		System.out.println("document uploaded ");
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//
//	@GetMapping("/download/{id}")
//	public ResponseEntity<Document> downloadFile(@PathVariable int id) {
//		customerService.downloadFile(id);
//		System.out.println("document downloaded");
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//
//	//  ACCOUNT CREATE
//	@PostMapping("/account-create")
//	public ResponseEntity<String> accountCreationRequest(@RequestParam("bankId") int bankId,
//			@RequestParam("customerId") int customerId,
//			@RequestParam("files") List<MultipartFile> files) {
//		String result = customerService.accountCreationRequest(bankId, customerId, files);
//		return new ResponseEntity<>(result, HttpStatus.OK);
//	}

}
