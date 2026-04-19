package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.boot.entity.Student;
import com.boot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void saveData(Student student) {
		this.studentRepository.save(student);
	}

	@Override
	public ResponseEntity<Iterable<Student>> getAllData() {
		return new ResponseEntity<Iterable<Student>>(studentRepository.findAll(), HttpStatus.OK);

	}

}
