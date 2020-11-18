package ru.diploma.restoran.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.diploma.restoran.model.Dish;
import ru.diploma.restoran.repository.dish.CrudDishRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Panfilov Dmitriy
 * 09.11.2020
 */

public interface DishRepository {


    Dish createDish(Dish dish);


}
