package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Student;
import com.boot.repository.StudentRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public void saveData(Student student) {
		log.info("save method from service get called");

		this.studentRepository.save(student);
		log.info("data saved from service");
	}
}
