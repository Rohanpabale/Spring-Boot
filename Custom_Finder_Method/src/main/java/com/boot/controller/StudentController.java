package com.boot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Student;
import com.boot.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("save")
	public ResponseEntity<String> saveNewStudent(@RequestBody Student student) {
		this.studentService.saveStudent(student);
		return new ResponseEntity<String>("data added", HttpStatus.OK);
	}

	@GetMapping("findByName/{name}")
	public ResponseEntity<Optional<Student>> findByName(@PathVariable("name") String name) {
		return new ResponseEntity<Optional<Student>>(this.studentService.findByName(name), HttpStatus.OK);
	}

	@DeleteMapping("deleteByName/{name}")
	public ResponseEntity<String> deleteByName(@PathVariable("name") String name) {
		this.studentService.deleteByName(name);
		return new ResponseEntity<String>("data deleted", HttpStatus.NO_CONTENT);
	}

	@GetMapping("findByNameAndCollegeName/{name}/{collegeName}")
	public ResponseEntity<Optional<Student>> findByNameAndCollegeName(@PathVariable("name") String name,
			@PathVariable("collegeName") String collegeName) {
		return new ResponseEntity<Optional<Student>>(this.studentService.findByNameAndCollegeName(name, collegeName),
				HttpStatus.OK);
	}

	@GetMapping("findByNameOrCollegeName/{name}/{collegeName}")
	public ResponseEntity<Optional<Student>> findByNameOrCollegeName(@PathVariable("name") String name,
			@PathVariable("collegeName") String collegeName) {
		return new ResponseEntity<Optional<Student>>(this.studentService.findByNameOrCollegeName(name, collegeName),
				HttpStatus.OK);
	}

	@GetMapping("findByMarksGreaterThan/{marks}")
	public ResponseEntity<Iterable<Student>> findByMarksGreaterThan(@PathVariable("marks") int marks) {
		return new ResponseEntity<Iterable<Student>>(this.studentService.findByMarksGreaterThan(marks), HttpStatus.OK);
	}

	// using @ query annoatation
	@GetMapping("getMarksByName/{name}")
	public ResponseEntity<Double> getMarksByName(@PathVariable("name") String name) {
		return new ResponseEntity<Double>(this.studentService.getMarksByName(name), HttpStatus.OK);
	}

}
