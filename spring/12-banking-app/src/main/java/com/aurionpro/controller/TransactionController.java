package com.aurionpro.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.exception.TransactionNotFoundException;
import com.aurionpro.model.Transaction;
import com.aurionpro.payload.TransactionDto;
import com.aurionpro.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired
    private TransactionService transactionService;

	public TransactionController(TransactionService transactionService) {
		super();
		this.transactionService = transactionService;
	}
	
	@GetMapping("/view")
    public ResponseEntity<List<TransactionDto>> viewTransactions(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(name = "accountNo") int accountNo) {
        List<TransactionDto> transactions = transactionService.getTransactionsByFilters(startDate, endDate, accountNo);
        return ResponseEntity.ok(transactions);
    }
	
	@GetMapping("/all")
	public TransactionDto getAllTransaction(@RequestParam(defaultValue = "10")int pageSize,@RequestParam(defaultValue = "0") int pageNo){
		return transactionService.getAllTransaction(pageNo,pageSize);
	}
	
	@GetMapping("/transactions/{id}")
	public ResponseEntity<Transaction> getTransactionById(@PathVariable int id) throws  TransactionNotFoundException {
		Optional<Transaction> optionalTransaction = transactionService.findById(id);
		Transaction transaction = null;
		if (optionalTransaction.isPresent()) {
			transaction = optionalTransaction.get();
			return new ResponseEntity<>(transaction, HttpStatus.OK);
		}else {
			throw new TransactionNotFoundException("transaction not found");
			
		}
	}
	
	@PostMapping("/addTransaction")
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction){
		Transaction tempTransaction = transactionService.addTransaction(transaction);
		return new ResponseEntity<>(tempTransaction,HttpStatus.CREATED);
	}
	@PostMapping("/deposit")
	public ResponseEntity<Transaction> deposit(@RequestParam int accountId, @RequestParam Double amount) {
		try {
			Transaction transaction = transactionService.deposit(accountId, amount);
			return ResponseEntity.ok(transaction);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PostMapping("/withdraw")
	public ResponseEntity<Transaction> withdraw(@RequestParam int accountId, @RequestParam Double amount) {
		try {
			Transaction transaction = transactionService.withdraw(accountId, amount);
			return ResponseEntity.ok(transaction);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PostMapping("/transfer")
	public ResponseEntity<Transaction> transfer(@RequestParam int sourceAccountId, @RequestParam int targetAccountId,
			@RequestParam Double amount) {
		try {
			Transaction transaction = transactionService.transfer(sourceAccountId, targetAccountId, amount);
			return ResponseEntity.ok(transaction);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("/account/{accountId}")
	public ResponseEntity<List<Transaction>> getTransactionsForAccount(@PathVariable int accountId) {
		try {
			List<Transaction> transactions = transactionService.getTransactionsForAccount(accountId);
			return ResponseEntity.ok(transactions);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
