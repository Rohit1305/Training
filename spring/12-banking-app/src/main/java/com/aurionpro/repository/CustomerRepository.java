package com.aurionpro.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findByEmailAndPassword(String email, String password);

}
