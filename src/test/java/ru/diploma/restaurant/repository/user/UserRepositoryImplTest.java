package ru.diploma.restaurant.repository.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import ru.diploma.restaurant.RestaurantTestData;
import ru.diploma.restaurant.UserTestData;
import ru.diploma.restaurant.model.User;
import ru.diploma.restaurant.repository.AbstractRepositoryTest;
import ru.diploma.restaurant.repository.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dmitriy Panfilov
 * 21.11.2020
 */
class UserRepositoryImplTest extends AbstractRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    void getAll() {
     //   assertArrayEquals(repository.getAll().toArray(), UserTestData.users.toArray());
       assertIterableEquals(UserTestData.users, repository.getAll());
      //  assertThat(repository.getAll()).isEqualTo(UserTestData.users);
    }

    @Test
    void createUser() {
        User user = UserTestData.getNew();
        User created = repository.createUser(user);
        user.setId(created.getId());
        assertThat(created).isEqualTo(user);
        System.out.println(created);
    }

    @Test
    void getUser() {
        User user = repository.getUser(UserTestData.USER1_ID);
        assertThat(user).isEqualTo(UserTestData.user1);
    }

    @Test
    void getAdminByRestaurant() {
        User admin = repository.getAdminByRestaurant( RestaurantTestData.RESTAURANT1_ID);
        assertThat(admin).isEqualTo(UserTestData.admin1);
    }

    @Test
    void deleteUser() {
        repository.deleteUser(UserTestData.USER1_ID);
        assertNull( repository.getUser(UserTestData.USER1_ID));

    }
}