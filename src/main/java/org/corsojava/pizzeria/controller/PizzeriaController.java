package org.corsojava.pizzeria.controller;

import java.util.List;

import org.corsojava.pizzeria.model.Ingredient;
import org.corsojava.pizzeria.model.Pizzeria;
import org.corsojava.pizzeria.repository.IngredientRepository;
import org.corsojava.pizzeria.repository.PizzeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/pizzeria")

public class PizzeriaController {
	
	@Autowired
	PizzeriaRepository pizzeriarep ;
	
	@Autowired
	IngredientRepository ingredientrep;
	
	
	@GetMapping	
	public String index(@RequestParam(name="keyword", required = false) String keyword,Model model) {		
		List<Pizzeria> elencopizzeria;
		
		if (keyword!=null && !keyword.isEmpty()) //RICERCA NOME PIZZA 
			elencopizzeria = pizzeriarep.findByNameLike("%"+ keyword + "%"); 
		else
			elencopizzeria = pizzeriarep.findAll();	
		model.addAttribute("elencopizzeria", elencopizzeria);
		return "index";
	}
	
	
	@GetMapping("/{id}")   // GESTISCE LE RICHIESTE DI TIPO /PIZZERIA/ID
	public String detail(@PathVariable("id") Integer id , Model model) {
	Pizzeria p = pizzeriarep.getReferenceById(id);
	model.addAttribute("detail" , p );
	return "detail";
	}
	
	
	@GetMapping("/create") // GESTISCE LE RICHIESTE GET TIPO /PIZZERIA/CREATE
	public String create(Model model) {

		Pizzeria p = new Pizzeria();
		
		List<Ingredient> IngredientList=ingredientrep.findAll();
		p.setName("Inserisci Nome Pizza");
		model.addAttribute("pizzeria", p);
		model.addAttribute("ingredienti", IngredientList);
		return "create";
	}
	
	@PostMapping("/create") //GESTISCE LE RICHIESTE POST /PIZZERIA/CREATE
	public String store(
			@Valid @ModelAttribute("pizzeria") Pizzeria formPizzeria,
			BindingResult bindingResult,
			Model model) {	
		
			if(bindingResult.hasErrors()) {
				return "create";
				
			}
			pizzeriarep.save(formPizzeria);
			
			return "redirect:/pizzeria"; 
			
		
	}
	
	@GetMapping("/edit/{id}") //GESTISCE LE RICHIESTEDEL TIPO /PIZZERIA/EDIT/ID
	public String edit(@PathVariable("id") Integer id,Model model ) {
		
		Pizzeria p;
		List<Ingredient> IngredientList=ingredientrep.findAll();
		p = pizzeriarep.getReferenceById(id);
		model.addAttribute("ingredienti", IngredientList);
		model.addAttribute("pizzeria", p);
		
	
		return "edit";
	}
	
	@PostMapping("/edit/{id}")
	public String update(
			@Valid @ModelAttribute Pizzeria formPizzeria,
			BindingResult bindingResult,
			Model model) {
		if(bindingResult.hasErrors())
			return "edit";
		
		pizzeriarep.save(formPizzeria);
		
		return "redirect:/pizzeria";
		
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		
		pizzeriarep.deleteById(id);
		
		return "redirect:/pizzeria";
	}
	
	
	
	
	
	
	
	
	
	
}
