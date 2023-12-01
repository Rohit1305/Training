package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.model.Account;
import com.aurionpro.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService service;
	
	public AccountController(AccountService service) {
		super();
		this.service = service;
	}
	@GetMapping("/get")
	public ResponseEntity<List<Account>> findAllAccounts(){
		List <Account> AccountsList=service.findAllAccounts();
		return new ResponseEntity<>(AccountsList,HttpStatus.OK);
	}
	@GetMapping("/find/{accountNo}")
	public ResponseEntity<Account> findAccountByNo(@PathVariable int id){
		Account AccountNo=service.findAccountByNo(id);
		return new ResponseEntity<>(AccountNo,HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Account>  addNewAccount(@RequestBody Account account ){
		Account addAccount =service.addNewAccount(account);
		return  new ResponseEntity<>(addAccount,HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account ) {
		Account updateAccount =service.updateAccount(account);
		return  new ResponseEntity<>(updateAccount,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteAccount(@PathVariable int id){
		service.deleteAccount(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
