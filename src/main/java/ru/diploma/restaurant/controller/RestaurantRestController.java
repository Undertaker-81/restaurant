package ru.diploma.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.diploma.restaurant.model.*;
import ru.diploma.restaurant.repository.*;
import ru.diploma.restaurant.to.RestaurantTo;
import ru.diploma.restaurant.util.UtilRestaurant;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private DishRepository dishRepository;

    @GetMapping
    public List<Restaurant> getAll(){
        return restaurantRepository.allRestaurant();
    }

    @GetMapping("/vote")
    public List<RestaurantTo> voteCurrentDate(@RequestParam(value = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
           return UtilRestaurant.getTos(voteRepository.findAllByVoteDate(date), getAll());
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable int id){
        return restaurantRepository.getRestaurant(id);
    }

    @GetMapping("/vote/{id}")
    public List<RestaurantTo> voteRestaurantByDate(@PathVariable int id,
            @RequestParam(value = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        //TODO время голосования и сверка
        return UtilRestaurant.getTos(voteRepository.findAllByVoteDateAndRestaurantId(date, id), getAll());
    }

    @GetMapping("/menu/{id}")
    public List<Dish> getMenuByRestaurant(@PathVariable int id,
                                           @RequestParam(value = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
       List<Integer> idDish = menuRepository.getAllByDateMenuAndIdRestaurant(date, id)
               .stream()
               .map(Menu::getIdDish)
               .collect(Collectors.toList());

        return dishRepository.findAllById(idDish);
    }


    @PostMapping(value = "/vote", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vote createVote(@RequestBody Vote vote){
       return voteRepository.save(vote);
    }

}
