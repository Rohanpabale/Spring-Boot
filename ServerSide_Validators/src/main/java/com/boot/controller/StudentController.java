package com.boot.controller;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.dto.StudentDto;
import com.boot.entity.Student;
import com.boot.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("save")
	public ResponseEntity<?> saveData(@Valid @RequestBody StudentDto studentDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		studentService.saveStudent(studentDto);
		return ResponseEntity.status(HttpStatus.CREATED).body("student created succesfully");
	}
}
