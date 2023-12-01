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

import com.aurionpro.entity.Instructor;
import com.aurionpro.entity.InstructorTechDetail;
import com.aurionpro.service.InstructorDetailService;
import com.aurionpro.service.InstructorService;


@RestController
@RequestMapping("/app")
public class InstructorController {
	
	@Autowired
	private InstructorService service;

	public InstructorController(InstructorService service) {
		super();
		this.service = service;
	}
	

	
	@GetMapping("/instruct")
	public ResponseEntity<List<Instructor>> getAllInstructors(){
		return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
	}
		
	@PostMapping("/instruct")
	public ResponseEntity<Instructor>  addNewInstructor(@RequestBody Instructor instructor ){
		return  new ResponseEntity<>(service.save(instructor),HttpStatus.CREATED);
	}
	@PutMapping("/instruct")
	public ResponseEntity<Instructor> updateInstuctor(@RequestBody Instructor instructor ) {
		return  new ResponseEntity<>(service.save(instructor),HttpStatus.OK);
	}
	@DeleteMapping("/instruct/{id}")
	public ResponseEntity<HttpStatus> deleteInstruct(@PathVariable int id){
		service.deleleById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/instruct/{id}/detail/{detailId}")
	  public ResponseEntity<HttpStatus> updateInstructorDetailsOfInstructor(
	      @PathVariable int id,@PathVariable int detailId){
	    service.updateInstructorDetails(id,detailId);
	    return new ResponseEntity<>(HttpStatus.OK);
	  }
	

}
