package com.aurionpro;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aurionpro.dao.StudentDao;
import com.aurionpro.entity.Student;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private StudentDao studentDao;
	

	public Application(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		addNewStudent();
//		findStudentById(10);
//		findAllStudents();
//		deleteStudentById();
//		findStudentByFirstName();
//		findStudentByFisrtNameAndLastName();
//		findStudentByEmail();
//		updateStudent();
		updateStudentById();
		

	}

	private void updateStudentById() {

		studentDao.updateStudentById(15);
	}

	private void updateStudent() {

		Student student = new Student(15,"shreyas", "sharma", "shryas@gmail.com");
		studentDao.updateStudent(student);
	}

	private void findStudentByEmail() {

		Student student =studentDao.findStudentByEmail("virat@gmail.com");
		System.out.println(student);
	}

	private void findStudentByFisrtNameAndLastName() {

		String firstName="rohit";
		String lastName="sharma";
		List <Student> students =studentDao.findStudentByFirstNameAndLastNAme(firstName,lastName);
		
		System.out.println(students);
	}

	private void findStudentByFirstName() {

		String firstName= "rohit";
		List <Student> students =studentDao.findStudentByFirstName(firstName);
		System.out.println(students);
		
	}

	private void deleteStudentById() {

		int id = 13;
		studentDao.deleteStudentById(id);
		
	}

	private void findAllStudents() {

		List <Student> students =studentDao.findAll();
		System.out.println(students +"/n");
		
	}

	private void findStudentById(int id) {

//		int id= 100;
		Student student = studentDao.findStudentById(id);
		if(student!=null) {
		System.out.println(student);
		}else {
			System.out.println("Student with id "+  id +" not found");
		}
	}

	private void addNewStudent() {

		Student student = new Student("rohit", "sharma", "rohit@gmail.com");
		studentDao.saveStudent(student);
		System.out.println("student saved successfully");

	}

}
