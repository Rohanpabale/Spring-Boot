package com.boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Student;
import com.boot.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Optional<Student> findByName(String name) {
		return studentRepository.findByName(name);
	}

	@Override
	public void saveStudent(Student student) {
		this.studentRepository.save(student);

	}

	@Override
	@Transactional
	public void deleteByName(String name) {
		this.studentRepository.deleteByName(name);
	}

	@Override
	public Iterable<Student> findByMarksGreaterThan(int marks) {
		return studentRepository.findByMarksGreaterThan(marks);
	}

	@Override
	public Optional<Student> findByNameAndCollegeName(String name, String collegeName) {
		return studentRepository.findByNameAndCollegeName(name, collegeName);
	}
	
	@Override
	public Optional<Student> findByNameOrCollegeName(String name, String collegeName) {
		return studentRepository.findByNameOrCollegeName(name, collegeName);
	}

	@Override
	public Double getMarksByName(String name) {
	
	return this.studentRepository.getMarksByName(name);
	}
	
	
}
