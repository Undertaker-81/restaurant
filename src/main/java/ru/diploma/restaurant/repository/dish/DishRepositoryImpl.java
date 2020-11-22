package ru.diploma.restaurant.repository.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.diploma.restaurant.model.Dish;
import ru.diploma.restaurant.repository.DishRepository;

import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 15.11.2020
 */
@Repository
public class DishRepositoryImpl  {

    @Autowired
    private  DishRepository repository;

    public Dish createDish(Dish dish) {
        if (dish != null){

            return repository.save(dish);
        }
       return null;
    }


    public Dish getDish(int id){
        return repository.getOne(id);
    }


    public List<Dish> getAlllDish() {
        return repository.findAll();
    }
}
