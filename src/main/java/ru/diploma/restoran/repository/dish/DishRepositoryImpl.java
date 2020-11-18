package ru.diploma.restoran.repository.dish;

import org.springframework.stereotype.Repository;
import ru.diploma.restoran.model.Dish;
import ru.diploma.restoran.repository.DishRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 15.11.2020
 */
@Repository
public class DishRepositoryImpl implements DishRepository {


    private final CrudDishRepository repository;

    public DishRepositoryImpl(CrudDishRepository repository) {
        this.repository = repository;
    }


    @Override
    public Dish createDish(Dish dish) {
        if (dish != null){

            return repository.save(dish);
        }
       return null;
    }
}
