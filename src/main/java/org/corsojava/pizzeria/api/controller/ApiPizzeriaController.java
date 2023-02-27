package org.corsojava.pizzeria.api.controller;

import java.util.List;
import java.util.Optional;

import org.corsojava.pizzeria.model.Ingredient;
import org.corsojava.pizzeria.model.Pizzeria;
import org.corsojava.pizzeria.repository.IngredientRepository;
import org.corsojava.pizzeria.repository.PizzeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiPizzeriaController {
	
	@Autowired
	PizzeriaRepository pizzeriarep;
	
	@Autowired
	IngredientRepository ingredientrep;
	
	@GetMapping() 
	public List<Pizzeria> index(){
		return pizzeriarep.findAll();
	}
	
	@GetMapping("{id}")		  //dettaglio alla singola pizza
	public ResponseEntity<Pizzeria> detail(@PathVariable("id") Integer id) {
		Optional<Pizzeria> res=pizzeriarep.findById(id);
		if (res.isPresent()) 
			return new ResponseEntity<Pizzeria>(res.get(), HttpStatus.OK);
	    else
	    	return new ResponseEntity<Pizzeria>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/create")
	public Pizzeria create(@RequestBody Pizzeria pizzeria) {
		return pizzeriarep.save(pizzeria);
	}
	
	
	@PutMapping("{id}")	        //aggiornamento pizza
	public Pizzeria update(@RequestBody Pizzeria pizzeria,
			@PathVariable("id") Integer id) {
		Pizzeria p = pizzeriarep.getReferenceById(id);
		p.setName(pizzeria.getName());
		p.setPrice(pizzeria.getPrice());
		return pizzeriarep.save(p);
	}
	
//	@DeleteMapping("/delete/{id}")       // Elimina pizza
//	public void delete(
//			@PathVariable("id") Integer id) {
//		pizzeriarep.deleteById(id);
//	}
	
	@DeleteMapping("/delete/{id}")	//eliminazione   Richiesta DELETE /api/xx
	public ResponseEntity<Pizzeria> delete(
			@PathVariable("id") Integer id) {		
		Optional<Pizzeria> res =pizzeriarep.findById(id);		
		if (res.isPresent()) {			
			pizzeriarep.deleteById(id);
			return new ResponseEntity<Pizzeria>( HttpStatus.OK);
		}			
	    else
	    	return new ResponseEntity<Pizzeria>(HttpStatus.NOT_FOUND);
		
	}
	
	
	
}
