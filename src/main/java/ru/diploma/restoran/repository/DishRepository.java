package ru.diploma.restoran.repository;

import ru.diploma.restoran.model.Dish;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Panfilov Dmitriy
 * 09.11.2020
 */
public interface DishRepository {

    List<Dish> menuByRestoranByDate(int restoranId, LocalDate date);

    List<Dish> createMenu(int restoranId, int userId);

    Dish createDish(int user_id);


}
