package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Student;
import com.boot.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public void saveData(Student student) {
		this.studentRepository.save(student);
	}

	public Iterable<Student> getAllData() {
		return this.studentRepository.findAll();
	}
}
