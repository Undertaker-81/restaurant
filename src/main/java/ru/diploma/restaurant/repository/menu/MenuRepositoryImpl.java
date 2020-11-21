package ru.diploma.restaurant.repository.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.diploma.restaurant.model.Menu;
import ru.diploma.restaurant.repository.MenuRepository;

import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 18.11.2020
 */
@Repository
public class MenuRepositoryImpl {

    @Autowired
    private MenuRepository repository;

    public List<Menu> menus(){
        return null;
    }
}
