package com.boot.service;

import java.util.Optional;

import com.boot.entity.Laptop;

public interface LaptopService {
	public void savelaptopData(Laptop laptop);

	public Iterable<Laptop> getAllData();

	public Optional<Laptop> getDataById(int id);

	public void updateLaptop(Laptop laptop);

	public void deleteData(Laptop laptop);
}
