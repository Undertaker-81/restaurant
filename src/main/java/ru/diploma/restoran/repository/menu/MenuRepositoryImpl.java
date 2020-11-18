package ru.diploma.restoran.repository.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.diploma.restoran.model.Menu;
import ru.diploma.restoran.repository.MenuRepository;

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
