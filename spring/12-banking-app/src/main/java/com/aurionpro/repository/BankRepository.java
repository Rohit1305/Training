package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.model.Bank;


public interface BankRepository extends JpaRepository<Bank, Integer>{

}
