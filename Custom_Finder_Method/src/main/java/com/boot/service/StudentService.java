package com.boot.service;

import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.boot.entity.Student;

public interface StudentService {
	public void saveStudent(Student student);

	public Optional<Student> findByName(String name);
	public void deleteByName(String name);
	public Iterable<Student> findByMarksGreaterThan(int marks);
	public Optional<Student> findByNameAndCollegeName(String name,String collegeName);
	public Optional<Student> findByNameOrCollegeName(String name,String collegeName);
	
	public Double getMarksByName(String name);
}
