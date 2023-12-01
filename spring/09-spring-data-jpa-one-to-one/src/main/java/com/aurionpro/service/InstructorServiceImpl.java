package com.aurionpro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aurionpro.entity.Instructor;
import com.aurionpro.entity.InstructorTechDetail;
import com.aurionpro.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService{

	private InstructorRepository repository ;
	private InstructorDetailService detailService;

	public InstructorServiceImpl(InstructorRepository repository, InstructorDetailService detailService) {
		super();
		this.repository = repository;
		this.detailService=detailService;
	}
	
	

	@Override
	public List<Instructor> findAll() {
		return repository.findAll();
	}

	@Override
	public Instructor save(Instructor instructor) {
		return repository.save(instructor);
	}

	@Override
	public void deleleById(int id) {
		repository.deleteById(id);
		
	}
	@Override
	  public void updateInstructorDetails(int id, int detailsId) {
	    Instructor instructor = repository.findById(id).get();
	    InstructorTechDetail instructorDetails = detailService.findById(detailsId);
	    instructor.setDetail(instructorDetails);
	    repository.save(instructor);
	  }
	
	

}
