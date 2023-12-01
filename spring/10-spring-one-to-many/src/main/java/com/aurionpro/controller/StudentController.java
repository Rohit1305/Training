package com.aurionpro.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Student;
import com.aurionpro.service.StudentService;

@RestController
@RequestMapping("/app")
public class StudentController {
	private StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> students =service.findAll();
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	@PostMapping("/student")
	public ResponseEntity<Student> addNewStudent(@RequestBody Student student){
		Student students =service.save(student);
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	@PutMapping("/student")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student){
		Student students =service.save(student);
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	@DeleteMapping("/student/{id}")
	public ResponseEntity<HttpStatus> deleteSttudent(@PathVariable int id){
		service.deleleById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
