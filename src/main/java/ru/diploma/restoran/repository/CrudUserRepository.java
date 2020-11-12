package ru.diploma.restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diploma.restoran.model.User;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Panfilov Dmitriy
 * 12.11.2020
 */
public interface CrudUserRepository extends JpaRepository<User, Integer> {

    List<User> getAllByRestoransAndDate(LocalDate date);
}
