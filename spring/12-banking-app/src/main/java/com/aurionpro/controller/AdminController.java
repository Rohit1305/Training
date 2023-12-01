package com.aurionpro.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.model.Admin;
import com.aurionpro.model.Customer;
import com.aurionpro.model.Document;
import com.aurionpro.model.Transaction;
import com.aurionpro.payload.AccountDto;
import com.aurionpro.payload.AdminRegistorDto;
import com.aurionpro.payload.LoginDto;
import com.aurionpro.payload.TransactionDto;
import com.aurionpro.service.AdminService;
import com.aurionpro.service.TransactionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService service;
	@Autowired
	private TransactionService transactionService;

	public AdminController(AdminService service) {
		super();
		this.service = service;
	}
	@GetMapping("/admin-details")
	 public ResponseEntity<List<Admin>> getAllAdmin() {
	  List<Admin> adminList = service.getAllAdmin();
	  return new ResponseEntity<>(adminList, HttpStatus.OK);
	 }
	
	@GetMapping("{id}")
	 public ResponseEntity<Admin> getAdminById(@PathVariable int id) {
	  Admin admin = service.findAdminById(id);
	  if (admin != null) {
	   return new ResponseEntity<>(admin, HttpStatus.OK);
	  }
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }



	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> findAllCustomer() {
		List<Customer> customerList = service.findAllCustomer();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable int id) {
		Customer customerId = service.findCustomerById(id);
		return new ResponseEntity<>(customerId, HttpStatus.OK);
	}

	@PostMapping("/customer")
	public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer) {
		Customer addCustomer = service.addNewCustomer(customer);
		return new ResponseEntity<>(addCustomer, HttpStatus.CREATED);
	}

	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		Customer updateAccount = service.updateCustomer(customer);
		return new ResponseEntity<>(updateAccount, HttpStatus.OK);
	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable int id) {
		service.deleteCustomer(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// ====ACTIVATE AND DEACTIVATE =========================================
	@PutMapping("/activate-customer/{customerId}")
	public ResponseEntity<Customer> activateCustomer(@PathVariable int customerId) {
		Customer activateCustomer = service.activateCustomer(customerId);
		return new ResponseEntity<>(activateCustomer, HttpStatus.CREATED);
	}

	@PutMapping("/deactivate-customer/{customerId}")
	public ResponseEntity<Customer> deactivateCustomer(@PathVariable int customerId) {
		Customer deactivateCustomer = service.deactivateCustomer(customerId);
		return new ResponseEntity<>(deactivateCustomer, HttpStatus.CREATED);
	}

	// ACCESS TRANSACTION
	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>> getTransactionsByDateAndAccount(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate, @RequestParam int accountNo) {

		List<Transaction> transactions = service.getTransactionsByDateAndAccount(startDate, endDate, accountNo);
		return new ResponseEntity<>(transactions, HttpStatus.OK);
	}
	
	@GetMapping("/all-transactions")
	public TransactionDto getAllTransaction(@RequestParam(defaultValue = "10")int pageSize,@RequestParam(defaultValue = "0") int pageNo){
		return transactionService.getAllTransaction(pageNo,pageSize);
	}
	
	// Admin LOGIn
	@PostMapping("/login")
	public ResponseEntity<Admin> adminLogin(@RequestBody LoginDto loginDto) {
		Admin admin = service.adminLogin(loginDto);
		if (admin != null) {
			return new ResponseEntity<>(admin, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<Admin> registerAdmin(@RequestBody AdminRegistorDto adminDto) {
		Admin adminToAdd = service.registerAdmin(adminDto);
		return new ResponseEntity<>(adminToAdd, HttpStatus.CREATED);
	}

//	// DOCUMENT
//	@PutMapping("/documents/{id}/accept")
//	public ResponseEntity<Document> acceptDocument(@PathVariable int id) {
//		Document acceptedDocument = service.acceptDocument(id);
//		return new ResponseEntity<>(acceptedDocument, HttpStatus.CREATED);
//
//	}
//
//	@PutMapping("/documents/{id}/reject")
//	public ResponseEntity<Document> rejectDocument(@PathVariable int id) {
//		Document rejectedDocument = service.rejectDocument(id);
//		return new ResponseEntity<>(rejectedDocument, HttpStatus.CREATED);
//	}

//	//ACCOUNT CREATE RESPONSE
//	@PostMapping("/account-create")
//	public ResponseEntity<String> processAccountCreationResponse(
//			@RequestBody AccountDto acDto,
//	        @RequestParam("documentId") int documentId,
//	        @RequestParam("status") String status
//	) {
//	    String result = service.accountCreationResponse(acDto,documentId, status);
//	    return new ResponseEntity<>(result, HttpStatus.OK);
//	}

}
