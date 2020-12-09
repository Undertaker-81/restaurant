package ru.diploma.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.diploma.restaurant.model.User;

/**
 * @author Panfilov Dmitriy
 * 09.12.2020
 */
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByEmail(String email);
}
