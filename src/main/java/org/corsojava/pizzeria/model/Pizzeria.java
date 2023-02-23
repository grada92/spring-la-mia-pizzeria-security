package org.corsojava.pizzeria.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity

public class Pizzeria {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	
	private int id;
	
	@Size(min = 5, max = 13, message = "non può essere più di 13 caratteri")
	@NotNull(message="il nome non può essere nullo")
	@NotEmpty(message="Il nome non deve essere vuoto")
	private String name;
	
	
	@NotNull(message="il prezzo non può essere nullo")
	private BigDecimal price;

	private String photo;
	
	
	@OneToMany (mappedBy = "pizzeria") // si riferisce al ManytoOne di pizzeria presente in Discount
	private List<Discount> Discounts;
	
	public int getId() {
		return id;
	}
	public List<Discount> getDiscounts() {
		return Discounts;
	}
	public void setDiscounts(List<Discount> Discounts) {
		this.Discounts = Discounts;
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
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
	
	
	public List<Ingredient> getIngredienties() {
		return ingredienties;
	}
	public void setIngredienties(List<Ingredient> ingredienties) {
		this.ingredienties = ingredienties;
	}


	@ManyToMany(cascade = CascadeType.ALL)
	private List<Ingredient> ingredienties;
	
	
		
}
