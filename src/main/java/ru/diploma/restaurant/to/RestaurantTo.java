package ru.diploma.restaurant.to;

import lombok.*;
import ru.diploma.restaurant.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author Dmitriy Panfilov
 * 09.12.2020
 */
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantTo  {

    private String name;

    private LocalDate date;

    private int voteCount;

}
