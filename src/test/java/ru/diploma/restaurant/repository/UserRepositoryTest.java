package ru.diploma.restaurant.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.diploma.restaurant.RestaurantTestData;
import ru.diploma.restaurant.UserTestData;
import ru.diploma.restaurant.model.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Panfilov Dmitriy
 * 09.12.2020
 */
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    void getAll() {
        //   assertArrayEquals(repository.getAll().toArray(), UserTestData.users.toArray());
        // assertIterableEquals(UserTestData.users, repository.getAll());
        assertThat(repository.findAll()).isEqualTo(UserTestData.users);

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

    @Test
    void getuserByEmail(){
        User user = repository.getUserByEmail("user@yandex.ru");
        assertThat(user).isEqualTo(UserTestData.user1);
    }
}