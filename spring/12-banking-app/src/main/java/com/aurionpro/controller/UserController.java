package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.model.Admin;
import com.aurionpro.model.Customer;
import com.aurionpro.model.User;
import com.aurionpro.payload.AdminRegistorDto;
import com.aurionpro.payload.CustomerRegistorDto;
import com.aurionpro.service.UserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> findAllUser(){
		List <User> userList=userService.findAllUser();
		return new ResponseEntity<>(userList,HttpStatus.OK);
	}
	@GetMapping("/customer/{id}")
	public ResponseEntity<User> findCustomerById(@PathVariable int id){
		User userId =userService.findUserById(id);
		return new ResponseEntity<>(userId,HttpStatus.OK);
	}
	@PutMapping("/customer")
	public ResponseEntity<User> updateUser(@RequestBody User user ) {
		User updateCustomer =userService.updateUser(user);
		return  new ResponseEntity<>(updateCustomer,HttpStatus.OK);
	}
	
//	@PostMapping("/customer/register")
//	 public ResponseEntity<Customer> registerCustomer(@RequestBody CustomerRegistorDto customerDto){
//	  Customer customerToAdd =userService.registerCustomer(customerDto);
//	  return new ResponseEntity<>(customerToAdd,HttpStatus.CREATED);
//	 }

//	@PostMapping("/admin/register")
//	 public ResponseEntity<Admin> registerAdmin(@RequestBody AdminRegistorDto adminDto){
//	  Admin adminToAdd =userService.registerAdmin(adminDto);
//	  return new ResponseEntity<>(adminToAdd,HttpStatus.CREATED);
//	 }
}
