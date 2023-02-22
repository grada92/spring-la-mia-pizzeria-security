package org.corsojava.pizzeria.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Discount {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private LocalDate StartDiscountDate;
	
	@NotNull
	private LocalDate EndDiscountDate;
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	

	public LocalDate getStartDiscountDate() {
		return StartDiscountDate;
	}


	public void setStartDiscountDate(LocalDate startDiscountDate) {
		StartDiscountDate = startDiscountDate;
	}


	public LocalDate getEndDiscountDate() {
		return EndDiscountDate;
	}


	public void setEndDiscountDate(LocalDate endDiscountDate) {
		EndDiscountDate = endDiscountDate;
	}


	public String getTitolo() {
		return Titolo;
	}


	public void setTitolo(String Titolo) {
		this.Titolo = Titolo;
	}


	public Pizzeria getPizzeria() {
		return pizzeria;
	}


	public void setPizzeria(Pizzeria pizzeria) {
		this.pizzeria = pizzeria;
	}


	private String Titolo;
	
	@NotNull
	@ManyToOne					// più istanze di Discount associate ad un'istanza di pizza
	private Pizzeria pizzeria;  // ad ogni pizza venduta 
	
}
