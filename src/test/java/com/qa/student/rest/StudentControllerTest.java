package com.qa.student.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.student.domain.Student;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:student-schema.sql", "classpath:student-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class StudentControllerTest {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper map;
	
	@Test
	void testCreateContent() throws Exception {
		Student newStu = new Student("Miles", LocalDate.of(2001, 4, 13), true, 3.9f);
		String newStuJSON = this.map.writeValueAsString(newStu);
		RequestBuilder mockRequest = post("/api/v1/student").contentType(MediaType.APPLICATION_JSON).content(newStuJSON);
		Student savedStu = new Student(2L, "Miles", LocalDate.of(2001, 4, 13), true, 3.9f);
		String savedStuJSON = this.map.writeValueAsString(savedStu);
		ResultMatcher matchStatus = status().isCreated();
		ResultMatcher matchBody = content().json(savedStuJSON);
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
	}
	
	@Test
	void testGetAll() throws Exception {
		Student readStu = new Student(1L, "Rebecca", LocalDate.of(1995, 4, 12), false, 3.5f, Period.between(LocalDate.of(1995, 4, 12), LocalDate.now()).getYears());
		List<Student> allStudent = List.of(readStu);
		String allStudentJSON = this.map.writeValueAsString(allStudent);
		
		RequestBuilder getReq = get("/api/v1/student");
		
		ResultMatcher status = status().isOk();
		ResultMatcher body = content().json(allStudentJSON);
		this.mock.perform(getReq).andExpect(status).andExpect(body);
		
	}
	
	@Test
	void testGetByID() throws Exception {
		Student readStu = new Student(1L, "Rebecca", LocalDate.of(1995, 4, 12), false, 3.5f, Period.between(LocalDate.of(1995, 4, 12), LocalDate.now()).getYears());
		String readStuJSON = this.map.writeValueAsString(readStu);
		Long ID = 1L;
		
		RequestBuilder getReqByID = get("/api/v1/student/" + ID);
		
		ResultMatcher status = status().isFound();
		ResultMatcher body = content().json(readStuJSON);
		this.mock.perform(getReqByID).andExpect(status).andExpect(body);
	}
	
	@Test
	void updateTest() throws Exception {
		Student updateStudent = new Student("Douglas", LocalDate.of(2000, 1, 1), true, 3.5f);
		String updateStudentJSON = this.map.writeValueAsString(updateStudent);
		Long IDupdate = 1L;

		RequestBuilder updateReq = put("/api/v1/student/" + IDupdate).contentType(MediaType.APPLICATION_JSON)
				.content(updateStudentJSON);

		Student retUpStu = new Student(1L, "Douglas", LocalDate.of(2000, 1, 1), true, 3.5f);
		String retUpdatedStuJSON = this.map.writeValueAsString(retUpStu);

		ResultMatcher retStatus = status().isAccepted();
		ResultMatcher retBody = content().json(retUpdatedStuJSON);

		this.mock.perform(updateReq).andExpect(retStatus).andExpect(retBody);
	}
	
	@Test
	void deleteTest() throws Exception {
		Student deleteStu = new Student(1L, "Rebecca", LocalDate.of(1995, 4, 12), false, 3.5f, Period.between(LocalDate.of(1995, 4, 12), LocalDate.now()).getYears());
		String deleteStuJSON = this.map.writeValueAsString(deleteStu);
		
		Long remId = 1L;
		RequestBuilder delRequest = delete("/api/v1/student/" + remId);
		ResultMatcher Status = status().isGone();
		ResultMatcher Body = content().json(deleteStuJSON);

		this.mock.perform(delRequest).andExpect(Status).andExpect(Body);
	}
	
}
