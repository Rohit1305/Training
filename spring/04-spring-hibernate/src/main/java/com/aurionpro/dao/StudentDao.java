package com.aurionpro.dao;

import java.util.List;

import com.aurionpro.entity.Student;

public interface StudentDao {
	public void saveStudent(Student student );

	public Student findStudentById(int id);

	public List<Student> findAll();

	public void deleteStudentById(int id);

	public List<Student> findStudentByFirstName(String firstName);

	public List<Student> findStudentByFirstNameAndLastNAme(String firstName, String lastName);

	public Student findStudentByEmail(String email);

	public void updateStudent(Student student);

	public void updateStudentById(int id);
	

}
