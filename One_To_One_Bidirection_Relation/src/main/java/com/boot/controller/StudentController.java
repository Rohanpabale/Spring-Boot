package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Student;
import com.boot.repository.StudentRepository;
import com.boot.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("save")
	public ResponseEntity<String> saveData(@RequestBody Student student) {
		this.studentService.saveData(student);
		return new ResponseEntity<String>("data saved", HttpStatus.CREATED);
	}

	@GetMapping("getAll")
	public ResponseEntity<Iterable<Student>> saveData() {
		ResponseEntity<Iterable<Student>> responseEntity = this.studentService.getAllData();
		return responseEntity;
	}
}
