package ru.diploma.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.diploma.restaurant.model.Dish;
import ru.diploma.restaurant.model.Menu;
import ru.diploma.restaurant.repository.MenuRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 09.12.2020
 */
@Service
public class MenuService{

    @Autowired
    MenuRepository repository;

    public List<Menu> getAllbyDateAndRestaurant(int restaurantId, LocalDate date) {
        return repository.getAllByDateMenuAndRestaurantId(date, restaurantId);
    }

    @Transactional
    public List<Menu> createMenu(int restaurantId, List<Dish> menu) {
        if (menu != null ){
            List<Menu> created = new ArrayList<>();
            for (Dish dishList : menu){
                created.add(new Menu(null,  restaurantId, dishList.getId(), LocalDate.now()));
            }
            return repository.saveAll(created);
        }
        return null;
    }
}
