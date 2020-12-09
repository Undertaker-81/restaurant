package ru.diploma.restaurant.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.diploma.restaurant.RestaurantTestData;
import ru.diploma.restaurant.VoteTestData;
import ru.diploma.restaurant.model.Restaurant;
import ru.diploma.restaurant.model.Vote;
import ru.diploma.restaurant.to.RestaurantTo;
import ru.diploma.restaurant.util.UtilRestaurant;

import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static java.time.LocalDate.of;

/**
 * @author Dmitriy Panfilov
 * 09.12.2020
 */
@SpringBootTest
class VoteRepositoryTest {

    @Autowired
    private VoteRepository repository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    void save() {
        Vote newVote = VoteTestData.getNew();
        Vote created = repository.save(VoteTestData.getNew());
        newVote.setId(created.getId());
        assertThat(created).isEqualTo(newVote);
        System.out.println(created);
    }

    @Test
    void getAllByDateAndRestaurantId() {
        assertIterableEquals(repository.findAllByVoteDateAndRestaurantId(of(2020, Month.NOVEMBER, 20), RestaurantTestData.RESTAURANT1_ID),
                VoteTestData.list1);
    }

    @Test
    void getAllbyDate() {
        assertIterableEquals(repository.findAllByVoteDate(of(2020, Month.NOVEMBER, 20)), VoteTestData.listAllOneDate);
    }

    @Test
    void getAll() {
        assertIterableEquals(repository.findAll(), VoteTestData.listAll);
    }

    @Test
    void toList(){
        List<Vote> votes = repository.findAll();
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        List<RestaurantTo> restaurantTos = UtilRestaurant.getTos(votes, restaurantList);
        restaurantTos.forEach(System.out::println);
    }
}