package ru.diploma.restoran.repository.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.diploma.restoran.model.Dish;
import ru.diploma.restoran.repository.DishRepository;

/**
 * @author Dmitriy Panfilov
 * 15.11.2020
 */
@Repository
public class DishRepositoryImpl  {


    private final DishRepository repository;

    public DishRepositoryImpl(DishRepository repository) {
        this.repository = repository;
    }


    public Dish createDish(Dish dish) {
        if (dish != null){

            return repository.save(dish);
        }
       return null;
    }
}
