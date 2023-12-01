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

import com.aurionpro.entity.Course;
import com.aurionpro.service.CourseService;

@RestController
@RequestMapping("/app")
public class CourseController {
	@Autowired
	private CourseService service;

	public CourseController(CourseService service) {
		super();
		this.service = service;
	}
	@GetMapping("/course")
	public ResponseEntity<List<Course>> getAllCourse(){
		List<Course> course =service.findAll();
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	@PostMapping("/course")
	public ResponseEntity<Course> addNewCourse(@RequestBody Course course){
		Course courses =service.save(course);
		return new ResponseEntity<>(courses,HttpStatus.OK);
	}
	@PutMapping("/course")
	public ResponseEntity<Course> updateCourse(@RequestBody Course course){
		Course courses =service.save(course);
		return new ResponseEntity<>(courses,HttpStatus.OK);
	}
	@DeleteMapping("/course/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable int id){
		service.deleleById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

}
