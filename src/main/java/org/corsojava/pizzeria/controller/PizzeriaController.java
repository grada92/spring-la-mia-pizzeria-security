package org.corsojava.pizzeria.controller;

import java.util.List;

import org.corsojava.pizzeria.model.Pizzeria;
import org.corsojava.pizzeria.repository.PizzeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pizzeria")

public class PizzeriaController {
	
	@Autowired
	PizzeriaRepository pizzeriarep ;
	
	@GetMapping
	public String index(Model model) {
		List<Pizzeria> elencopizzeria=pizzeriarep.findAll();
		model.addAttribute("elencopizzeria",elencopizzeria);
		return "index";
	}
	
}
