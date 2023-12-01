package com.aurionpro.payload;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.model.AccountType;
import com.aurionpro.model.Bank;
import com.aurionpro.model.Customer;
import com.aurionpro.model.Transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountDto {
	private int accountNo;
	private double balance;
	private boolean active;
	private List<Transaction> transactionList = new ArrayList<>();
	private AccountType accountType;
	private Bank bank;
	private Customer customer;
	public AccountDto(AccountType accountType, Bank bank) {
		super();
		this.accountType = accountType;
		this.bank = bank;
	}

}
