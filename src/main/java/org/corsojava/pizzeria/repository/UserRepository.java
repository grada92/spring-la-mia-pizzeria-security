package org.corsojava.pizzeria.repository;

import java.util.Optional;

import org.corsojava.pizzeria.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

}