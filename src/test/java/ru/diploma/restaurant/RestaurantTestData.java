package ru.diploma.restaurant;

/**
 * @author Dmitriy Panfilov
 * 21.11.2020
 */
import ru.diploma.restaurant.model.Restaurant;

import java.util.List;

import static ru.diploma.restaurant.model.Restaurant.START_SEQ;
import static ru.diploma.restaurant.UserTestData.*;

public class RestaurantTestData {
    public static final Integer RESTAURANT1_ID = START_SEQ + 19;

    public static final Restaurant SOKOL = new Restaurant(START_SEQ + 19, "Сокол", admin1);
    public static final Restaurant ROG = new Restaurant(START_SEQ + 20, "Рога и копыта", admin2);
    public static final Restaurant SHIPL = new Restaurant(START_SEQ + 21, "Шашлык и пляски", admin3);

    public static final List<Restaurant> restaurants = List.of(SOKOL, ROG, SHIPL);

    public static Restaurant getNew(){
        return new Restaurant(null, "Новый ресторан", admin1);
    }
}
