package com.boot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Laptop;
import com.boot.service.LaptopService;

@RestController
@RequestMapping("laptop")
public class LaptopController {
	@Autowired
	private LaptopService laptopService;

	@PostMapping("save")
	public ResponseEntity<String> saveNewData(@RequestBody Laptop laptop) {
		this.laptopService.savelaptopData(laptop);
		return new ResponseEntity<String>("data saved", HttpStatus.CREATED);
	}

	@GetMapping("get")
	public ResponseEntity<Iterable<Laptop>> getAllData() {
		return new ResponseEntity<Iterable<Laptop>>(this.laptopService.getAllData(), HttpStatus.OK);
	}

	@GetMapping("getById/{id}")
	public ResponseEntity<Optional<Laptop>> getAllData(@PathVariable("id") int id) {
		return new ResponseEntity<Optional<Laptop>>(this.laptopService.getDataById(id), HttpStatus.OK);

	}

	@PutMapping("update")
	public ResponseEntity<String> updateData(@RequestBody Laptop laptop) {
		this.laptopService.updateLaptop(laptop);
		return new ResponseEntity<String>("data updated", HttpStatus.OK);
	}

	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<String> deleteData(@PathVariable("id") int id) {
		Optional<Laptop> optionalLaptop = this.laptopService.getDataById(id);
		this.laptopService.deleteData(optionalLaptop.get());
		return new ResponseEntity<String>("data deleted of id" + id, HttpStatus.NO_CONTENT);
	}

}
