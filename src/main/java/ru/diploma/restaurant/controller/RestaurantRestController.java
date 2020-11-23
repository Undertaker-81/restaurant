package ru.diploma.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.diploma.restaurant.model.Restaurant;
import ru.diploma.restaurant.model.User;
import ru.diploma.restaurant.model.Vote;
import ru.diploma.restaurant.repository.MenuRepository;
import ru.diploma.restaurant.repository.RestaurantRepository;
import ru.diploma.restaurant.repository.UserRepository;
import ru.diploma.restaurant.repository.VoteRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Dmitriy Panfilov
 * 15.11.2020
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = RestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantRestController {

    static final String REST_URL = "/restaurant";

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping
    public List<Restaurant> getAll(){
        return restaurantRepository.allRestaurant();
    }
    @GetMapping("/vote")
    public List<Vote> voteCurrentDate(@RequestParam(value = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return voteRepository.findAllByVoteDate(date);
        //TODO TO
    }
    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable int id){
        return restaurantRepository.getRestaurant(id);
        //TODO TO
    }
    //TODO getmenuRestaurant
    //TODO createVote


}
