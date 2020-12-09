package ru.diploma.restaurant;

/**
 * @author Dmitriy Panfilov
 * 21.11.2020
 */

import ru.diploma.restaurant.model.Vote;

import java.time.Month;
import java.util.List;


import static java.time.LocalDate.of;

public class VoteTestData {
    public static final Vote vote1 = new Vote(1, 1, 1, of(2020, Month.NOVEMBER, 20));
    public static final Vote vote2 = new Vote(2, 5, 1, of(2020, Month.NOVEMBER, 20));
    public static final Vote vote3 = new Vote(3, 6, 1, of(2020, Month.NOVEMBER, 20));
    public static final Vote vote4 = new Vote(4, 7, 1, of(2020, Month.NOVEMBER, 20));
    public static final Vote vote5 = new Vote(5, 8, 2, of(2020, Month.NOVEMBER, 20));
    public static final Vote vote6 = new Vote(6, 9, 2, of(2020, Month.NOVEMBER, 20));
    public static final Vote vote7 = new Vote(7, 10, 3, of(2020, Month.NOVEMBER, 20));
    public static final Vote vote8 = new Vote(8, 1, 3, of(2020, Month.NOVEMBER, 21));
    public static final Vote vote9 = new Vote(9, 5, 3, of(2020, Month.NOVEMBER, 21));
    public static final Vote vote10 = new Vote(10, 6, 3, of(2020, Month.NOVEMBER, 21));
    public static final Vote vote11 = new Vote(11, 7, 1, of(2020, Month.NOVEMBER, 21));
    public static final Vote vote12 = new Vote(12, 8, 1, of(2020, Month.NOVEMBER, 21));
    public static final Vote vote13 = new Vote(13, 9, 2, of(2020, Month.NOVEMBER, 21));

    public static final List<Vote> list1 = List.of(vote1,vote2,vote3,vote4);
    public static final List<Vote> list2 = List.of(vote5,vote6);
    public static final List<Vote> list3 = List.of(vote7);
    public static final List<Vote> list4 = List.of(vote8,vote9,vote10);
    public static final List<Vote> list5 = List.of(vote11,vote12);
    public static final List<Vote> list6 = List.of(vote13);

    public static final List<Vote> listAll = List.of(vote1,vote2,vote3,vote4,vote5,vote6,vote7,vote8,vote9,vote10,vote11,vote12,vote13);
    public static final List<Vote> listAllOneDate = List.of(vote1,vote2,vote3,vote4,vote5,vote6,vote7);
    public static final List<Vote> listAllSecondDate = List.of(vote8,vote9,vote10,vote11,vote12,vote13);

    public static Vote getNew(){
        return new Vote(1, 1, of(2020, Month.NOVEMBER, 22));
    }


}