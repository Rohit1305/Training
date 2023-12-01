package com.aurionpro.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.aurionpro.model.Transaction;
import com.aurionpro.payload.TransactionDto;

public interface TransactionService {

	List<TransactionDto> getTransactionsByFilters(LocalDate startDate, LocalDate endDate, int accountNo);

	TransactionDto getAllTransaction(int pageNo, int pageSize);

	Optional<Transaction> findById(int id);

	Transaction addTransaction(Transaction transaction);

	Transaction deposit(int accountId, Double amount);

	Transaction withdraw(int accountId, Double amount);

	Transaction transfer(int sourceAccountId, int targetAccountId, Double amount);

	List<Transaction> getTransactionsForAccount(int accountId);

}
