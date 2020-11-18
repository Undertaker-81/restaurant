package ru.diploma.restoran.repository;

import ru.diploma.restoran.model.Restoran;
import ru.diploma.restoran.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Panfilov Dmitriy
 * 12.11.2020
 */
public interface RestoramRepository {

    List<Restoran> allRestorans();

    Restoran getRestoran(int id);

    User getAdmin(int id);

    void delete(int id);

    Restoran save(Restoran restoran, User user);
}
