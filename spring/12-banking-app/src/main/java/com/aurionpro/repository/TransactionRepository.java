package com.aurionpro.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.model.Account;
import com.aurionpro.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	List<Transaction> findByTransDateBetweenAndAccount_AccountNo(Date startDate, Date endDate, int accountNo);

	List<Transaction> findByAccount(Account account);

}
