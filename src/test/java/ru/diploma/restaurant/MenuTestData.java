package ru.diploma.restaurant;

import ru.diploma.restaurant.model.Menu;

import java.time.Month;
import java.util.List;

import static java.time.LocalDate.of;
import static ru.diploma.restaurant.model.Restaurant.START_SEQ;
/**
 * @author Dmitriy Panfilov
 * 21.11.2020
 */
public class MenuTestData {
    public static final Menu dish1 = new Menu(START_SEQ + 22,100010, 100019, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish2 = new Menu(START_SEQ + 23,100013, 100019, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish3 = new Menu(START_SEQ + 24,100015, 100019, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish4 = new Menu(START_SEQ + 25,100017, 100019, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish5 = new Menu(START_SEQ + 26,100018, 100019, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish6 = new Menu(START_SEQ + 27,100018, 100020, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish7 = new Menu(START_SEQ + 28,100015, 100020, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish8 = new Menu(START_SEQ + 29,100010, 100020, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish9 = new Menu(START_SEQ + 30,100011, 100021, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish10 = new Menu(START_SEQ + 31,100013, 100021, of(2020, Month.NOVEMBER, 20));
    public static final Menu dish11 = new Menu(START_SEQ + 32,100014, 100021, of(2020, Month.NOVEMBER, 20));

    public static final List<Menu> SOKOL_MENU = List.of(dish1,dish2,dish3,dish4,dish5);
    public static final List<Menu> ROG_MENU = List.of(dish6,dish7,dish8);
    public static final List<Menu> SHIPL_MENU = List.of(dish9,dish10,dish11);

    public static Menu getNew1(){

        return new Menu(null, START_SEQ + 19, START_SEQ + 11,of(2020, Month.NOVEMBER, 21) );
    }
    public static Menu getNew2(){

        return new Menu(null, START_SEQ + 19, START_SEQ + 12,of(2020, Month.NOVEMBER, 21) );
    }

    public static Menu getNew3(){

        return new Menu(null, START_SEQ + 19, START_SEQ + 13,of(2020, Month.NOVEMBER, 21) );
    }
}
