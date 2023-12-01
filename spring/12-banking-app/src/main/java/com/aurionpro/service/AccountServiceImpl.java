package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.model.Account;
import com.aurionpro.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepository accountRepository;
	

	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public List<Account> findAllAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public Account addNewAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account updateAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public void deleteAccount(int id) {
		accountRepository.deleteById(id);
	}

	@Override
	public Account findAccountByNo(int id) {
		return accountRepository.findById(id).get();
	}

	

}
