package org.corsojava.pizzeria.controller;

import java.util.List;

import org.corsojava.pizzeria.model.Ingredient;
import org.corsojava.pizzeria.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ingredienties")
public class IngredientController {
	
	@Autowired
	private IngredientRepository ingredientrep;
	
	@GetMapping()		// GET /categories
	public String index(			
			Model model) {	
		List<Ingredient> res = ingredientrep.findAll(Sort.by("name"));	//tutti le categorie ordinate per nome
		model.addAttribute("ingredienti", res);
		return "indexIng";
	}

	@GetMapping("/create")	
	public String create(Model model) {
		Ingredient ingredient =new Ingredient();	//non esiste ancora sul DB

		model.addAttribute("ingredienti", ingredient);

		return "createIng";
	}

	@PostMapping("/create")  // /ingredienties/create
	public String store(
		@Valid @ModelAttribute("ingredienti") Ingredient formIngredient, 
		BindingResult bindingResult,
		Model model){

		if (bindingResult.hasErrors())
			return "createIng";

		ingredientrep.save(formIngredient);

		return "redirect:/ingredienties"; //genera un altro get

	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {

	   ingredientrep.deleteById(id);

	   return "redirect:/ingredienties";
	}

}
