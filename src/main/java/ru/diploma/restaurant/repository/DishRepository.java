package ru.diploma.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diploma.restaurant.model.Dish;

/**
 * @author Panfilov Dmitriy
 * 09.11.2020
 */

public interface DishRepository extends JpaRepository<Dish, Integer> {

}
