package ru.diploma.restaurant.repository.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.diploma.restaurant.model.Dish;
import ru.diploma.restaurant.model.Menu;
import ru.diploma.restaurant.repository.MenuRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 18.11.2020
 */
@Repository
@Transactional(readOnly = true)
public class MenuRepositoryImpl {

    @Autowired
    private MenuRepository repository;

    public List<Menu> getAllbyDateAndRestaurant(int idRestaurant, LocalDate date){
        return repository.getAllByDateMenuAndIdRestaurant(date, idRestaurant);
    }
    @Transactional
    public List<Menu>  createMenu(int restaurantId, List<Dish> menu){
        if (menu != null ){
            List<Menu> created = new ArrayList<>();
            for (Dish dishList : menu){
                created.add(new Menu(null, restaurantId, dishList.getId(), LocalDate.now()));
            }
            return repository.saveAll(created);
        }
        return null;
    }
}
