package com.aurionpro.service;

//import java.awt.print.Pageable;
import java.util.List;

//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Student;
import com.aurionpro.exception.StudentNotFoundException;
import com.aurionpro.payload.StudentPageDto;
import com.aurionpro.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository repository;

	public StudentServiceImpl(StudentRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Student> findAll() {
		return repository.findAll();
	}

	@Override
	public Student findById(int studentId) throws StudentNotFoundException {
		Student student = null;
		student = repository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with id " + studentId));
		return student;
	}

	@Override
	public Student updateStudent(Student student) {

		return repository.save(student);
	}

	@Override
	public Student saveStudent(Student student) {

		return repository.save(student);
//		HttpMessageNotReadableException
	}

	@Override
	public void deleteById(int studentId) throws StudentNotFoundException {
		if (repository.existsById(studentId)) {
			repository.deleteById(studentId);
		} else {
			throw new StudentNotFoundException("Student not found with id " + studentId);
		}
	}

	@Override
	public StudentPageDto findAll(int pageNo, int pageSize, String title, String direction) {

		Sort sort = null;
	    if (direction.equalsIgnoreCase("desc")) {
	      sort = Sort.by(Sort.Direction.DESC, title);
	    } else {
	      sort = Sort.by(Sort.Direction.ASC, title);
	    }
	Pageable pageable = PageRequest.of(pageNo, pageSize,sort);
	Page<Student> page = repository.findAll(pageable);
	List<Student> students = page.getContent();
	
	StudentPageDto studentDto = new StudentPageDto();
	studentDto.setContent(students);
	studentDto.setFirst(page.isFirst());
	studentDto.setLast(page.isLast());
	studentDto.setHasNext(page.hasNext());
	studentDto.setHasPrevious(page.hasPrevious());
	studentDto.setNumberOfElements(page.getNumberOfElements());
	studentDto.setPageNumber(page.getNumber());
	studentDto.setTotalElements(page.getTotalElements());
	studentDto.setTotalPages(page.getTotalPages());
	
	return studentDto;
	}

	@Override
	public List<Student> findByEmail(String email) {

		List<Student> students =repository.findByEmail(email);
		return students;
	}

	@Override
	public List<Student> findByFirstName(String firstName) {
		List<Student> students =repository.findByFirstName(firstName);
		return students;
	}

//	@Override
//	public StudentPageDto findAll(int pageNo, int pageSize,String title,String direction) {
//		   Sort sort = null;
//		    if (direction.equalsIgnoreCase("desc")) {
//		      sort = Sort.by(Sort.Direction.DESC, title);
//		    } else {
//		      sort = Sort.by(Sort.Direction.ASC, title);
//		    }
//		Pageable pageable = PageRequest.of(pageNo, pageSize);
//		Page<Student> page = repository.findAll(pageable);
//		List<Student> students = page.getContent();
//		
//		StudentPageDto studentDto = new StudentPageDto();
//		studentDto.setContent(students);
//		studentDto.setFirst(page.isFirst());
//		studentDto.setLast(page.isLast());
//		studentDto.setHasNext(page.hasNext());
//		studentDto.setHasPrevious(page.hasPrevious());
//		studentDto.setNumberOfElements(page.getNumberOfElements());
//		studentDto.setPageNumber(page.getNumber());
//		studentDto.setTotalElements(page.getTotalElements());
//		studentDto.setTotalPages(page.getTotalPages());
//		
//		return studentDto;
//	}

}
