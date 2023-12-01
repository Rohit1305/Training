package com.aurionpro.service;

import java.util.List;

import com.aurionpro.model.Account;

public interface AccountService {

	List<Account> findAllAccounts();

	Account addNewAccount(Account account);

	Account updateAccount(Account account);

	void deleteAccount(int id);

	Account findAccountByNo(int id);



}
