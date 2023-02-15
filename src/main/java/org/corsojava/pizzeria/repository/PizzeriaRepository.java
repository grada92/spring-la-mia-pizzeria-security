package org.corsojava.pizzeria.repository;

import java.util.List;

import org.corsojava.pizzeria.model.Pizzeria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzeriaRepository extends JpaRepository<Pizzeria , Integer>{
	
	public List<Pizzeria>  findByNameLike(String keyword);
}
