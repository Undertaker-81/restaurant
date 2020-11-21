package ru.diploma.restaurant.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author Panfilov Dmitriy
 * 11.11.2020
 */
@NoArgsConstructor
@Getter
@Setter
public class RestoranTo {

    private int id;

    private String name;

    private LocalDate date;

    private int voteCount;

}
