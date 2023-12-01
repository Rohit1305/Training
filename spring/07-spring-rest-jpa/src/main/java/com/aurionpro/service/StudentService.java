package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.Student;
import com.aurionpro.exception.StudentNotFoundException;
import com.aurionpro.payload.StudentPageDto;

public interface StudentService {
	List<Student> findAll();

	Student findById(int studentId) throws StudentNotFoundException;

	Student updateStudent(Student student);

	Student saveStudent(Student student) throws Exception;

	void deleteById(int studentId) throws StudentNotFoundException;

//	StudentPageDto findAll(int pageNo, int pageSize);

	StudentPageDto findAll(int pageNo, int pageSize, String title, String direction);

	List<Student> findByEmail(String email);

	List<Student> findByFirstName(String firstName);

}
