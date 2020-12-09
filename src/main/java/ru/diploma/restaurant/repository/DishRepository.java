package ru.diploma.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.diploma.restaurant.model.Dish;

import java.util.List;

/**
 * @author Panfilov Dmitriy
 * 09.11.2020
 */
@Transactional(readOnly = true)
public interface DishRepository  extends JpaRepository<Dish, Integer>{


}