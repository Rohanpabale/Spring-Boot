package com.boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Laptop;
import com.boot.repository.LaptopRepository;

@Service
public class LaptopServiceImpl implements LaptopService {
	@Autowired
	private LaptopRepository laptopRepository;

	@Override
	public void savelaptopData(Laptop laptop) {
	this.laptopRepository.save(laptop);
	}

	@Override
	public Iterable<Laptop> getAllData() {
		return this.laptopRepository.findAll();

	}

	@Override
	public Optional<Laptop> getDataById(int id) {
		return this.laptopRepository.findById(id);
	}

	@Override
	public void updateLaptop(Laptop laptop) {
		this.laptopRepository.save(laptop);

	}

	@Override
	public void deleteData(Laptop laptop) {
		this.laptopRepository.delete(laptop);

	}

}
