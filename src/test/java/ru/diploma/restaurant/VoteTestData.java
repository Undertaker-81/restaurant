package ru.diploma.restaurant;

/**
 * @author Dmitriy Panfilov
 * 21.11.2020
 */

import ru.diploma.restaurant.model.Vote;

import java.time.Month;
import java.util.List;

import static ru.diploma.restaurant.model.Restaurant.START_SEQ;
import static java.time.LocalDateTime.of;

public class VoteTestData {
        public static final Vote vote1 = new Vote(START_SEQ + 33, 100000, 100019, of(2020, Month.NOVEMBER, 20,0,0));
        public static final Vote vote2 = new Vote(START_SEQ + 34, 100004, 100019, of(2020, Month.NOVEMBER, 20,0,0));
        public static final Vote vote3 = new Vote(START_SEQ + 35, 100005, 100019, of(2020, Month.NOVEMBER, 20,0,0));
        public static final Vote vote4 = new Vote(START_SEQ + 36, 100006, 100019, of(2020, Month.NOVEMBER, 20,0,0));
        public static final Vote vote5 = new Vote(START_SEQ + 37, 100007, 100020, of(2020, Month.NOVEMBER, 20,0,0));
        public static final Vote vote6 = new Vote(START_SEQ + 38, 100008, 100020, of(2020, Month.NOVEMBER, 20,0,0));
        public static final Vote vote7 = new Vote(START_SEQ + 39, 100009, 100021, of(2020, Month.NOVEMBER, 20,0,0));
        public static final Vote vote8 = new Vote(START_SEQ + 40, 100000, 100021, of(2020, Month.NOVEMBER, 21,0,0));
        public static final Vote vote9 = new Vote(START_SEQ + 41, 100004, 100021, of(2020, Month.NOVEMBER, 21,0,0));
        public static final Vote vote10 = new Vote(START_SEQ + 42, 100005, 100021, of(2020, Month.NOVEMBER, 21,0,0));
        public static final Vote vote11 = new Vote(START_SEQ + 43, 100006, 100019, of(2020, Month.NOVEMBER, 21,0,0));
        public static final Vote vote12 = new Vote(START_SEQ + 44, 100007, 100019, of(2020, Month.NOVEMBER, 21,0,0));
        public static final Vote vote13 = new Vote(START_SEQ + 45, 100008, 100020, of(2020, Month.NOVEMBER, 21,0,0));

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
                return new Vote(null, 100000, 100019, of(2020, Month.NOVEMBER, 22,0,0));
        }


}
