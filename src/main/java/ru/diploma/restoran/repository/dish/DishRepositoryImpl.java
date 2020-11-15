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
    public List<Dish> menuByRestoranByDate(int restoranId, LocalDate date) {
        return repository.findAllByRestorans(restoranId);
    }

    @Override
    public List<Dish> createMenu(int restoranId, int userId) {
        return null;
    }

    @Override
    public Dish createDish(int user_id) {
        return null;
    }
}
