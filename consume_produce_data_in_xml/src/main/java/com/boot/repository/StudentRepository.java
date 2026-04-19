package com.boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.boot.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
