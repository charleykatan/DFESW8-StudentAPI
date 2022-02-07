package com.qa.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.student.domain.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

}
