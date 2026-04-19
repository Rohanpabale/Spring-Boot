package com.boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.Laptop;

@Repository
public interface LaptopRepository extends CrudRepository<Laptop, Integer> {

}
