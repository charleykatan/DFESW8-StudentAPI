package com.qa.student.service;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface CRUDInterface<T> {

	//CREATE METHOD
	T Create(T t);
		
	//READ ALL
	List<T> getAll();
		
	//READ BY ID
	T getById(Long id);
		
	//UPDATE
	T updateByID(Long id, T t);
		
	//DELETE - either present/not
	T deleteByID(Long id);
	
}
