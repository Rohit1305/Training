package com.aurionpro.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.model.Account;
import com.aurionpro.model.Transaction;
import com.aurionpro.model.TransactionType;
import com.aurionpro.payload.TransactionDto;
import com.aurionpro.repository.AccountRepository;
import com.aurionpro.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private AccountRepository accountRepository;

	public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
		super();
		this.transactionRepository = transactionRepository;
		this.accountRepository = accountRepository;
	}

	private Transaction createTransaction(Account account, Account targetAccount, Double amount, TransactionType type) {
		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		transaction.setReceiverAccount(targetAccount != null ? targetAccount.getAccountNo() : 0);
		transaction.setAmount(amount);
		transaction.setTransType(type);
		transaction.setTransDate(new Date());

		return transaction;
	}

	@Override
	public List<TransactionDto> getTransactionsByFilters(LocalDate startDate, LocalDate endDate, int accountNo) {
		return null;
	}

	@Override
	public TransactionDto getAllTransaction(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Transaction> page = transactionRepository.findAll(pageable);

		List<Transaction> transaction = page.getContent();
		TransactionDto transactionDto = new TransactionDto();

		transactionDto.setContent(transaction);
		transactionDto.setFirst(page.isFirst());
		transactionDto.setLast(page.isLast());
		transactionDto.setHasNext(page.hasNext());
		transactionDto.setHasPrevious(page.hasPrevious());
		transactionDto.setNumberOfElements(page.getNumberOfElements());
		transactionDto.setPageNumber(page.getNumber());
		transactionDto.setTotalElements(page.getTotalElements());
		transactionDto.setTotalPages(page.getTotalPages());

		return transactionDto;
	}

	@Override
	public Optional<Transaction> findById(int id) {
		return transactionRepository.findById(id);
	}

	@Override
	public Transaction addTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction deposit(int accountId, Double amount) {

		Account account = accountRepository.findById(accountId).orElse(null);
		if (account != null) {
			account.setBalance(account.getBalance() + amount);
			accountRepository.save(account);

			Transaction transaction = createTransaction(account, null, amount, TransactionType.DEPOSIT);
			return transactionRepository.save(transaction);
		}
		return null;
	}

	@Override
	public Transaction withdraw(int accountId, Double amount) {

		Account account = accountRepository.findById(accountId).orElse(null);
		if (account != null && account.getBalance() >= amount) {
			account.setBalance(account.getBalance() - amount);
			accountRepository.save(account);

			Transaction transaction = createTransaction(account, null, amount, TransactionType.WITHDRAWAL);
			return transactionRepository.save(transaction);
		}
		return null;
	}

	@Override
	public Transaction transfer(int sourceAccountId, int targetAccountId, Double amount) {

		Account sourceAccount = accountRepository.findById(sourceAccountId).orElse(null);
		Account targetAccount = accountRepository.findById(targetAccountId).orElse(null);

		if (sourceAccount != null && targetAccount != null && sourceAccount.getBalance() >= amount) {
			sourceAccount.setBalance(sourceAccount.getBalance() - amount);
			targetAccount.setBalance(targetAccount.getBalance() + amount);

			accountRepository.save(sourceAccount);
			accountRepository.save(targetAccount);

			Transaction transaction = createTransaction(sourceAccount, targetAccount, amount, TransactionType.TRANSFER);
			return transactionRepository.save(transaction);
		}
		return null;
	}

	@Override
	public List<Transaction> getTransactionsForAccount(int accountId) {

		Account account = accountRepository.findById(accountId).orElse(null);
		if (account != null) {
			return transactionRepository.findByAccount(account);
		}
		return Collections.emptyList();
	}

}
