package ru.diploma.restaurant;

/**
 * @author Dmitriy Panfilov
 * 21.11.2020
 */
import ru.diploma.restaurant.model.Dish;

import java.util.List;

import static ru.diploma.restaurant.model.Restaurant.START_SEQ;

public class DishTestData {
    public static final Integer DISH1_ID = START_SEQ + 10;

    public static final Dish dish1 = new Dish(START_SEQ + 10, "Пельмени", 60);
    public static final Dish dish2 = new Dish(START_SEQ + 11, "чай", 15);
    public static final Dish dish3 = new Dish(START_SEQ + 12, "картофельное пюре", 20);
    public static final Dish dish4 = new Dish(START_SEQ + 13, "Котлета", 35);
    public static final Dish dish5 = new Dish(START_SEQ + 14, "шашлык", 250);
    public static final Dish dish6 = new Dish(START_SEQ + 15, "салат цезарь", 60);
    public static final Dish dish7 = new Dish(START_SEQ + 16, "салат зимний", 60);
    public static final Dish dish8 = new Dish(START_SEQ + 17, "кофе", 25);
    public static final Dish dish9 = new Dish(START_SEQ + 18, "борщ", 40);

    public static List<Dish> dishes = List.of(dish1,dish2,dish3,dish4,dish5,dish6,dish7,dish8,dish9);

    public static Dish getNew(){
        return new Dish( "new Dish", 100);
    }
}
