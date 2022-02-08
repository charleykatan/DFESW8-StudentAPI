package com.qa.student.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.student.domain.Student;
import com.qa.student.repo.StudentRepo;

@SpringBootTest
@ActiveProfiles("test")
public class StudentServiceTest {
	
	private Student newStudent;
	private Student savedStudent;
	private Student secondStudent;
	private Student unsavedStudent;
	
	@MockBean
	private StudentRepo repo;
	
	@Autowired
	private StudentService service;
	
	@BeforeEach
	void setUp() {
		newStudent = new Student("Jessie", LocalDate.of(1994, 9, 3), false, 4.1f);
		savedStudent = new Student(1L, "Jessie", LocalDate.of(1994, 9, 3), false, 4.1f);
		secondStudent = new Student("Margaret", LocalDate.of(1946, 6, 3), true, 3.1f);
		unsavedStudent = new Student("Harry", LocalDate.of(1991,  3, 4), true, 4.5f);
	}
	
	@Test
	public void createTest() {
		Mockito.when(this.repo.save(newStudent)).thenReturn(savedStudent);
		assertThat(this.service.Create(newStudent)).isEqualTo(savedStudent);
		Mockito.verify(this.repo, Mockito.times(1)).save(newStudent);
	}
	
	@Test
	public void getAllTest() {
		List<Student> studentList = new ArrayList<>();
		this.repo.save(newStudent);
		this.repo.save(secondStudent);
		studentList.add(newStudent);
		studentList.add(secondStudent);
		Mockito.when(this.repo.findAll()).thenReturn(studentList);
		assertEquals(studentList, this.service.getAll());
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void getByIDTest() {
		this.repo.save(newStudent);
		Long validID = 1L;
		Optional<Student> validStudent = Optional.ofNullable(savedStudent);
		Mockito.when(this.repo.findById(validID)).thenReturn(validStudent);
		assertEquals(validStudent.get(), this.service.getById(validID));
		Mockito.verify(this.repo, Mockito.times(1)).findById(validID);
	}
	
	@Test
	public void testUpdate() {
		Long id = 1L;
		Student toUpdate = new Student("Amanda", LocalDate.of(1987, 7, 7), true, 4.1f);
		Optional<Student> optStu = Optional.of(new Student());
		Student updated = new Student(id, toUpdate.getName(), toUpdate.getDob(), toUpdate.isScholarshipStatus(), toUpdate.getGpa());
		Mockito.when(this.repo.existsById(id)).thenReturn(true, false);
		Mockito.when(this.repo.findById(id)).thenReturn(optStu);
		Mockito.when(this.repo.save(updated)).thenReturn(updated);
		assertThat(this.service.updateByID(id, toUpdate)).isEqualTo(updated);
		Mockito.verify(this.repo, Mockito.times(1)).save(updated);
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}
	
	@Test
	public void testUpdateNotExists() {
		Long invalidID = 5L;
		Student toUpdate = new Student("Amanda", LocalDate.of(1987, 7, 7), true, 4.1f);
		Mockito.when(this.repo.existsById(invalidID)).thenReturn(false);
		assertThat(this.service.updateByID(invalidID, toUpdate)).isEqualTo(null);
		Mockito.verify(this.repo, Mockito.times(1)).findById(invalidID);
		}
	
	@Test
	public void testDelete() {
		Long id = 1L;
		Optional<Student> optStu = Optional.of(new Student());
		Student deleted = optStu.get();
		Mockito.when(this.repo.findById(id)).thenReturn(optStu);
		assertThat(this.service.deleteByID(id)).isEqualTo(deleted);
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(id);
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}
	
}
