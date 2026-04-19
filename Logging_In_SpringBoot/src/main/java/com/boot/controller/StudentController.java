package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Student;
import com.boot.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("student")
@Slf4j
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("save")
	public ResponseEntity<String> saveData(@RequestBody Student student) {
		if (student.getName() != null && student.getCity() != null) {
			log.info("data sent to service.......");
			this.studentService.saveData(student);
			log.info("data saved..........");
			return new ResponseEntity<String>("data Saved", HttpStatus.CREATED);
		}

		else
			log.error("envalid data entred by user");
		return new ResponseEntity<String>("invalid data", HttpStatus.BAD_REQUEST);

	}
}
