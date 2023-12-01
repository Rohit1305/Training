package com.aurionpro.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.aurionpro.entity.Student;
import com.aurionpro.exception.StudentExceptionResponse;
import com.aurionpro.exception.StudentNotFoundException;
import com.aurionpro.payload.StudentPageDto;
import com.aurionpro.repository.StudentRepository;
import com.aurionpro.service.StudentService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
public class StudentController {
	private StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
		
	}
	@GetMapping("/students/{studentId}")
	public ResponseEntity<Student> getAllStudentById(@PathVariable int studentId) throws StudentNotFoundException{
		return  new ResponseEntity<>(service.findById(studentId),HttpStatus.OK);
	}
	@PostMapping("/students")
	public ResponseEntity<Student>  addNewStudent(@RequestBody Student student ) throws Exception {
		return  new ResponseEntity<>(service.saveStudent(student),HttpStatus.CREATED);
	}
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student ) {
		return  new ResponseEntity<>(service.updateStudent(student),HttpStatus.OK);
	}
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<HttpStatus> deleteStudentById(@PathVariable int studentId) throws StudentNotFoundException {
		 service.deleteById(studentId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/students")
	public StudentPageDto getStudents(
			@RequestParam(defaultValue = "3") int pageSize,
			@RequestParam(defaultValue = "0")int pageNo,
			@RequestParam(defaultValue = "id")String title,
			@RequestParam(defaultValue = "ASC")String direction){
		StudentPageDto studentDto = service.findAll(pageNo,pageSize,title,direction);
		return studentDto;
	}
	@GetMapping("/students/email/{email}")
	public ResponseEntity <List<Student>> getEmail(@PathVariable String email){
		List<Student> student = service.findByEmail(email);
		return new ResponseEntity<> (student,HttpStatus.OK);
	}
	@GetMapping("/students/firstName/{firstName}")
	public ResponseEntity <List<Student>> getFirstName(@PathVariable String firstName){
		List<Student> student = service.findByFirstName(firstName);
		return new ResponseEntity<> (student,HttpStatus.OK);
	}
	

	

	
	
}
