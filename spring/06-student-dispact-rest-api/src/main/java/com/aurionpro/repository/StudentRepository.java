package com.aurionpro.repository;

import java.util.List;

import com.aurionpro.entity.Student;

public interface StudentRepository {

	List<Student> findAll();

	Student findById(int studentId);

	Student updateStudent(Student student);

	Student saveStudent(Student student);

	void deleteById(int studentId);




}
