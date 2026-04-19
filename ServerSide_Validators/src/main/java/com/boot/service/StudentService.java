package com.boot.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dto.StudentDto;
import com.boot.entity.Student;
import com.boot.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private StudentRepository studentRepository;

	public void saveStudent(StudentDto studentDto) {
		Student student = modelMapper.map(studentDto, Student.class);
		this.studentRepository.save(student);
	}
}
