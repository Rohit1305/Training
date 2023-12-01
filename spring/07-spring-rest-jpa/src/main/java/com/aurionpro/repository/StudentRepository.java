package com.aurionpro.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aurionpro.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	List<Student> findByEmail(String email);

	@Query(value ="select s from Student s where s.firstName=?1")
	List<Student> findByFirstName(String firstName);


}
