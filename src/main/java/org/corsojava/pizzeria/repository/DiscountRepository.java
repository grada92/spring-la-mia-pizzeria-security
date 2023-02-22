package org.corsojava.pizzeria.repository;


import org.corsojava.pizzeria.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount , Integer>{

}
