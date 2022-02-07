package com.qa.student.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Please enter a name") // sets not null and error message
	@Column
	private String name;

	@NotNull
	@Column
	private LocalDate dob;
	
	@Column
	@NotNull
	private boolean scholarshipStatus;
	
	@Column
	private float gpa;
	
	@Transient
	private int age;
	
	public Student() {	
	}

	public Student(String name, LocalDate dob,
			boolean scholarshipStatus, float gpa) {
		this.name = name;
		this.dob = dob;
		this.scholarshipStatus = scholarshipStatus;
		this.gpa = gpa;
	}

	public Student(Long id, String name, LocalDate dob,
			boolean scholarshipStatus, float gpa) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.scholarshipStatus = scholarshipStatus;
		this.gpa = gpa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public boolean isScholarshipStatus() {
		return scholarshipStatus;
	}

	public void setScholarshipStatus(boolean scholarshipStatus) {
		this.scholarshipStatus = scholarshipStatus;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public int getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, dob, gpa, name, scholarshipStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && Objects.equals(dob, other.dob)
				&& Float.floatToIntBits(gpa) == Float.floatToIntBits(other.gpa) && Objects.equals(name, other.name)
				&& scholarshipStatus == other.scholarshipStatus;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dob=" + dob + ", scholarshipStatus=" + scholarshipStatus
				+ ", gpa=" + gpa + ", age=" + age + "]";
	}
	
}
