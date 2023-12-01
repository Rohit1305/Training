package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.model.Customer;
import com.aurionpro.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{


}
