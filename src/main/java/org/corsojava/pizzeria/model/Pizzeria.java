package org.corsojava.pizzeria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Pizzeria {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	private int id;
	private String name;
	private int price;
	private String photo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Pizzeria [id=" + id + ", name=" + name + ", price=" + price + ", photo=" + photo + "]";
	}
	
	
	
	
	
}
