package ru.diploma.restaurant.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.diploma.restaurant.RestaurantTestData;
import ru.diploma.restaurant.UserTestData;
import ru.diploma.restaurant.model.User;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Panfilov Dmitriy
 * 09.12.2020
 */
@SpringBootTest
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
        User created = repository.save(user);
        user.setId(created.getId());
        assertThat(created).isEqualTo(user);
        System.out.println(created);
    }

    @Test
    void getUser() {
        Optional<User> user = repository.findById(UserTestData.USER1_ID);
         assertThat(user.get()).isEqualTo(UserTestData.user1);
    }



    @Test
    void deleteUser() {
        repository.delete(UserTestData.user1);
        assertTrue( repository.findById(UserTestData.USER1_ID).isEmpty());

    }

    @Test
    void getUserByEmail(){
        User user = repository.getUserByEmail("user@yandex.ru");
        assertThat(user).isEqualTo(UserTestData.user1);
    }
}