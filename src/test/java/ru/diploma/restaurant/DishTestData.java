package ru.diploma.restaurant;

/**
 * @author Dmitriy Panfilov
 * 21.11.2020
 */
import ru.diploma.restaurant.model.Dish;

import java.util.List;


public class DishTestData {


    public static final Dish dish1 = new Dish(1, "Пельмени", 60);
    public static final Dish dish2 = new Dish(2, "чай", 15);
    public static final Dish dish3 = new Dish(3, "картофельное пюре", 20);
    public static final Dish dish4 = new Dish(4, "Котлета", 35);
    public static final Dish dish5 = new Dish(5, "шашлык", 250);
    public static final Dish dish6 = new Dish(6, "салат цезарь", 60);
    public static final Dish dish7 = new Dish(7, "салат зимний", 60);
    public static final Dish dish8 = new Dish(8, "кофе", 25);
    public static final Dish dish9 = new Dish(9, "борщ", 40);

    public static List<Dish> dishes = List.of(dish1,dish2,dish3,dish4,dish5,dish6,dish7,dish8,dish9);

    public static Dish getNew(){
        return new Dish( "new Dish", 100);
    }
}