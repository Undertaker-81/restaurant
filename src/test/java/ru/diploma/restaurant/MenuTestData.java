package ru.diploma.restaurant;

import ru.diploma.restaurant.model.Menu;

import java.time.Month;
import java.util.List;

import static java.time.LocalDate.of;

/**
 * @author Dmitriy Panfilov
 * 21.11.2020
 */
public class MenuTestData {
    public static final Menu dish1 = new Menu(1,1, 1, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish2 = new Menu(2,1, 4, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish3 = new Menu(3,1, 5, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish4 = new Menu(4, 1, 7,of(2020, Month.NOVEMBER, 20));
    public static final Menu dish5 = new Menu(5,1, 8, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish6 = new Menu(6,2, 2, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish7 = new Menu(7,2, 4, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish8 = new Menu(8,2, 5, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish9 = new Menu(9,3, 6, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish10 = new Menu(10,3, 7, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish11 = new Menu(11,3, 8, of(2020, Month.NOVEMBER, 20));

    public static final List<Menu> SOKOL_MENU = List.of(dish1,dish2,dish3,dish4,dish5);
    public static final List<Menu> ROG_MENU = List.of(dish6,dish7,dish8);
    public static final List<Menu> SHIPL_MENU = List.of(dish9,dish10,dish11);

    public static Menu getNew1(){

        return new Menu(null, 1, 1,of(2020, Month.NOVEMBER, 21) );
    }
    public static Menu getNew2(){

        return new Menu(null, 1, 3,of(2020, Month.NOVEMBER, 21) );
    }

    public static Menu getNew3(){

        return new Menu(null, 1, 5,of(2020, Month.NOVEMBER, 21) );
    }
}