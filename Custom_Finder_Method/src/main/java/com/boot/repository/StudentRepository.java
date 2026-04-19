package com.boot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.boot.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
	public Optional<Student> findByName(String name);
	public void deleteByName(String name);
	public Iterable<Student> findByMarksGreaterThan(Integer marks);
	public Optional<Student> findByNameAndCollegeName(String name,String collegeName);
	public Optional<Student> findByNameOrCollegeName(String name,String collegeName);
	
	@Query("select s.marks from Student s where s.name=:n")
	public Double getMarksByName(@Param("n") String name);
}
