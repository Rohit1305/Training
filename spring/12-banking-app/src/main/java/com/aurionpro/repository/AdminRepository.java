package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Admin findByEmailAndPassword(String email, String password);

}
