package com.boot.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Laptop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String companyName;
	private double price;
	private String color;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Laptop(Integer id, String companyName, double price, String color) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.price = price;
		this.color = color;
	}

	public Laptop() {
		super();
	}

}
