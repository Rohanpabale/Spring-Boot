package com.boot.controller;

import java.awt.PageAttributes.MediaType;
import java.net.ResponseCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	@PostMapping(value = "save", consumes = org.springframework.http.MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {
		this.studentService.saveData(student);
		return new ResponseEntity<String>("data saved", HttpStatus.CREATED);
	}

	@GetMapping(value = "getAll", produces = org.springframework.http.MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Iterable<Student>> getAll() {
		return new ResponseEntity<Iterable<Student>>(this.studentService.getAllData(), HttpStatus.OK);
	}
}
