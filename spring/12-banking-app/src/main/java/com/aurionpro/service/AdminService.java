package com.aurionpro.service;

import java.util.Date;
import java.util.List;

import com.aurionpro.model.Admin;
import com.aurionpro.model.Customer;
import com.aurionpro.model.Document;
import com.aurionpro.model.Transaction;
import com.aurionpro.payload.AccountDto;
import com.aurionpro.payload.AdminRegistorDto;
import com.aurionpro.payload.LoginDto;

public interface AdminService {

	List<Customer> findAllCustomer();

	Customer findCustomerById(int id);

	Customer addNewCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	void deleteCustomer(int id);

	Customer activateCustomer(int customerId);

	Customer deactivateCustomer(int customerId);

	List<Transaction> getTransactionsByDateAndAccount(Date startDate, Date endDate, int accountNo);

	Admin adminLogin(LoginDto loginDto);

	Admin registerAdmin(AdminRegistorDto adminDto);

	List<Admin> getAllAdmin();

	Admin findAdminById(int id);

//	Document acceptDocument(int id);
//
//	Document rejectDocument(int id);
//
//	String accountCreationResponse(AccountDto acDto, int documentId, String status);



}
