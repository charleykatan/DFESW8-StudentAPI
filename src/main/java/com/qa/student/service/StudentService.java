package com.qa.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.student.domain.Student;
import com.qa.student.repo.StudentRepo;

@Service
public class StudentService implements CRUDInterface<Student>{

	private StudentRepo repo;
	
	public StudentService(StudentRepo repo) {
		this.repo = repo;
	}
	
	@Override
	public Student Create(Student student) {
		return this.repo.save(student);
	}

	@Override
	public List<Student> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Student getById(Long id) {
		Optional<Student> optionalStudent = this.repo.findById(id);
		return optionalStudent.get();
	}

	@Override
	public Student updateByID(Long id, Student student) {
		Optional<Student> optionalStudent = this.repo.findById(id);
		if (optionalStudent.isPresent()) {
			Student existing = optionalStudent.get();
			existing.setName(student.getName());
			existing.setDob(student.getDob());
			existing.setScholarshipStatus(student.isScholarshipStatus());
			existing.setGpa(student.getGpa());
			return this.repo.save(existing);
		}
		return null;
	}

	@Override
	public Student deleteByID(Long id) {
		Optional<Student> toDelete = this.repo.findById(id);
		this.repo.deleteById(id);
		return toDelete.orElse(null);
	}

}
