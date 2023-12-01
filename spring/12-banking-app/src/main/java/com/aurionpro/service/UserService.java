package com.aurionpro.service;

import java.util.List;

import com.aurionpro.model.Admin;
import com.aurionpro.model.Customer;
import com.aurionpro.model.User;
import com.aurionpro.payload.AdminRegistorDto;
import com.aurionpro.payload.CustomerRegistorDto;

public interface UserService {
//
//	Customer registerCustomer(CustomerRegistorDto customerDto);

//	Admin registerAdmin(AdminRegistorDto adminDto);
	
	List<User> findAllUser();

	User findUserById(int id);

	User updateUser(User user);



}
