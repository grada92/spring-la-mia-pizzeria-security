package org.corsojava.pizzeria.repository;

import org.corsojava.pizzeria.model.Pizzeria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzeriaRepository extends JpaRepository<Pizzeria , Integer>{
	
}
