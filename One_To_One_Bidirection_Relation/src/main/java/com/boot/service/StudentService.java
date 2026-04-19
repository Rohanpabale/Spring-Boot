package com.boot.service;

import org.springframework.http.ResponseEntity;

import com.boot.entity.Student;

public interface StudentService {
	public void saveData(Student student);

	public ResponseEntity<Iterable<Student>> getAllData();
}
