package com.qa.student.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class StudentUnitTest {

	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Student.class).usingGetClass().withPrefabValues(Student.class,
				new Student("Malcolm", LocalDate.of(2001, 12, 12), true, 4.3f), new Student()).verify();
	}

	@Test
	public void testConstructorWithID() {
		Student student = new Student(5L, "Roger", LocalDate.of(1987, 1, 15), false, 4.0f);
		assertNotNull(student.getId());
		assertNotNull(student.getName());
		assertNotNull(student.getDob());
		assertNotNull(student.isScholarshipStatus());
		assertNotNull(student.getGpa());
		assertEquals(Long.valueOf(5L), student.getId());
		assertEquals("Roger", student.getName());
		assertEquals(LocalDate.of(1987, 1, 15), student.getDob());
		assertEquals(false, student.isScholarshipStatus());
		assertEquals(4.0f, student.getGpa(), 0.00000001);
	}

	@Test
	public void testToString() {
		Student stu = new Student(6L, "Karen", LocalDate.of(1997, 4, 1), true, 3.5f);
		assertEquals("Student [id=6, name=Karen, dob=" + LocalDate.of(1997, 4, 1) +", scholarshipStatus=true, gpa=3.5, age=" + stu.getAge() +"]",
				stu.toString());
	}
	
	@Test
	public void testGettersAndSetters() {
		Student s = new Student(7L, "Danny", LocalDate.of(2000, 1, 1), false, 5.0f);
		s.setName("Mandy");
		assertEquals("Mandy", s.getName());
		s.setDob(LocalDate.of(1990, 12, 31));
		assertEquals(LocalDate.of(1990, 12, 31), s.getDob());
		s.setScholarshipStatus(true);
		assertTrue(s.isScholarshipStatus());
		s.setGpa(2.0f);
		assertEquals(2.0f, s.getGpa(), 0.0000001);
		assertEquals(31, s.getAge());
	}
}
