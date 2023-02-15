package org.corsojava.pizzeria.controller;

import java.util.List;

import org.corsojava.pizzeria.model.Pizzeria;
import org.corsojava.pizzeria.repository.PizzeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pizzeria")

public class PizzeriaController {
	
	@Autowired
	PizzeriaRepository pizzeriarep ;
	
	
	@GetMapping	
	public String index(@RequestParam(name="keyword", required = false) String keyword,Model model) {		
		List<Pizzeria> elencopizzeria;
		
		if (keyword!=null && !keyword.isEmpty())
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
	
	
	
	
}
