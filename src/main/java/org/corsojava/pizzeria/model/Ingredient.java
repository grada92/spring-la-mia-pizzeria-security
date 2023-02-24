package org.corsojava.pizzeria.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Pizzeria> getPizzeria() {
		return pizzeria;
	}


	public void setPizzeria(List<Pizzeria> pizzeria) {
		this.pizzeria = pizzeria;
	}


	@NotNull (message = "name must be not null")
	private String name;
	
	
	@ManyToMany(mappedBy = "ingredienties")
	@JsonBackReference
	private List<Pizzeria> pizzeria;
	
	
}
