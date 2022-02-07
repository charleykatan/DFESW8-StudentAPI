package com.qa.student.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.qa.student.domain.Student;
import com.qa.student.service.CRUDInterface;

import java.util.List;


@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

	private CRUDInterface<Student> service;
	
	public StudentController(CRUDInterface<Student> service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student s) {
		return new ResponseEntity<Student>(this.service.Create(s), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<List<Student>>(this.service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentByID(@PathVariable Long id) {
		return new ResponseEntity<Student>(this.service.getById(id), HttpStatus.FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudentByID(@PathVariable Long id, @RequestBody Student s) {
		return new ResponseEntity<Student>(this.service.updateByID(id, s), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteByID(@PathVariable Long id) {
		if (this.service.deleteByID(id) == null) {
			return new ResponseEntity<Student>(this.service.deleteByID(id), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(this.service.deleteByID(id), HttpStatus.GONE);
	}
	
}
