package com.aurionpro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aurionpro.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao {
	private EntityManager manager;

	public StudentDaoImpl(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Transactional
	@Override
	public void saveStudent(Student student) {
		manager.persist(student);

	}

	@Override
	public Student findStudentById(int id) {
		return manager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query = manager.createQuery("from Student", Student.class);
		return query.getResultList();
	}

	@Transactional
	@Override
	public void deleteStudentById(int id) {

		Student student = manager.find(Student.class, id);
		if (student != null) {
			manager.remove(student);
			System.out.println("student deleted successfully");
		} else {
			System.out.println("could not find student");
		}
	}

	@Override
	public List<Student> findStudentByFirstName(String firstName) {

		TypedQuery<Student> query = manager.createQuery("select s from Student s where s.firstName=?1", Student.class);
		query.setParameter(1, firstName);
		return query.getResultList();
	}

	@Override
	public List<Student> findStudentByFirstNameAndLastNAme(String firstName, String lastName) {

		TypedQuery<Student> query = manager.createQuery("select s from Student s where s.firstName=?1 and s.lastName=?2", Student.class);
		query.setParameter(1, firstName);
		query.setParameter(2, lastName);
		return query.getResultList();
	}

	@Override
	public Student findStudentByEmail(String email) {
		TypedQuery<Student> query = manager.createQuery("select s from Student s where s.email=?1", Student.class);
		query.setParameter(1, email);
		return query.getSingleResult();
	}

	@Transactional
	@Override
	public void updateStudent(Student student) {
		manager.merge(student);
		System.out.println("updated successfully ");
	}

	@Transactional
	@Override
	public void updateStudentById(int id) {

		Student student = manager.find(Student.class, id);
		student.setFirstName("rahul");
		System.out.println("Student updated");
	}

}
