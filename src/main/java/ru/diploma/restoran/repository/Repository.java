package ru.diploma.restoran.repository;

import ru.diploma.restoran.model.Dish;
import ru.diploma.restoran.model.Restoran;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Panfilov Dmitriy
 * 09.11.2020
 */
public interface Repository {

    List<Dish> menuByRestoranByDate(int restoranId, LocalDate date);

    List<Restoran> allRestoransByDate(LocalDate date);

    Restoran getRestoran(int id);

    List<Dish> createMenu(int restoranId, int userId);

    Dish createDish(int user_id);

    int countVoteByRestoran(int restoranId, LocalDate date);

    void vote(int restoranId, int userId, LocalDateTime date);

}
