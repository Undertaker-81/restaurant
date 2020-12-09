package ru.diploma.restaurant;

/**
 * @author Dmitriy Panfilov
 * 21.11.2020
 */
import ru.diploma.restaurant.model.Restaurant;

import java.util.List;

import static ru.diploma.restaurant.UserTestData.*;

public class RestaurantTestData {

    public static final Integer RESTAURANT1_ID = 1;

    public static final Restaurant SOKOL = new Restaurant(1, "Сокол", admin1);
    public static final Restaurant ROG = new Restaurant(2, "Рога и копыта", admin2);
    public static final Restaurant SHIPL = new Restaurant(3, "Шашлык и пляски", admin3);

    public static final List<Restaurant> restaurants = List.of(SOKOL, ROG, SHIPL);

    public static Restaurant getNew(){
        return new Restaurant( "Новый ресторан", admin1);
    }
}
