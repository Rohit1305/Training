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

import com.aurionpro.entity.Instructor;
import com.aurionpro.entity.InstructorTechDetail;
import com.aurionpro.service.InstructorDetailService;

@RestController
@RequestMapping("/app")
public class InstructorDetailController {
	private InstructorDetailService service;

	public InstructorDetailController(InstructorDetailService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/detail")
	public ResponseEntity<List<InstructorTechDetail>> getAllDetails(){
		List <InstructorTechDetail> detailsList=service.findAll();
		return new ResponseEntity<>(detailsList,HttpStatus.OK);
	}
	@PostMapping("/detail")
	public ResponseEntity<InstructorTechDetail>  addNewDetail(@RequestBody InstructorTechDetail detail ){
		InstructorTechDetail addDetail =service.save(detail);
		return  new ResponseEntity<>(addDetail,HttpStatus.CREATED);
	}
	@PutMapping("/detail")
	public ResponseEntity<InstructorTechDetail> updateDetail(@RequestBody InstructorTechDetail detail ) {
		InstructorTechDetail updateDetail =service.save(detail);
		return  new ResponseEntity<>(updateDetail,HttpStatus.OK);
	}
	@DeleteMapping("/detail/{id}")
	public ResponseEntity<HttpStatus> deleteDetail(@PathVariable int id){
		service.deleleById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/detail/{id}/instructor")
	  public ResponseEntity<Instructor> getInstrustor(@PathVariable int id){
	    Instructor instructor = service.getInstructor(id);
	    return new ResponseEntity<>(instructor,HttpStatus.OK);
	  }
	

}
