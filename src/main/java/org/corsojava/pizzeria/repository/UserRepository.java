package org.corsojava.pizzeria.repository;

import org.corsojava.pizzeria.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Integer>{
	
	
}
