package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.aurionpro.entity.Teacher;
import com.aurionpro.service.TeacherService;

@RestController
@RequestMapping("/app")
public class TeacherController {
	@Autowired
	private TeacherService service;

	public TeacherController(TeacherService service) {
		super();
		this.service = service;
	}
	@GetMapping("/teacher")
	public ResponseEntity<List<Teacher>> getAllTeacher(){
		List<Teacher> course =service.findAll();
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	@PostMapping("/teacher")
	public ResponseEntity<Teacher> addNewTeacher(@RequestBody Teacher teacher){
		Teacher teachers =service.save(teacher);
		return new ResponseEntity<>(teachers,HttpStatus.OK);
	}
	@PutMapping("/teacher")
	public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher){
		Teacher teachers =service.save(teacher);
		return new ResponseEntity<>(teachers,HttpStatus.OK);
	}
	@DeleteMapping("/teacher/{id}")
	public ResponseEntity<HttpStatus> deleteTeacher(@PathVariable int id){
		service.deleleById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
