package ru.diploma.restaurant.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Panfilov Dmitriy
 * 11.11.2020
 */
@NoArgsConstructor
@Getter
@Setter
public class RestaurantTo {

    private int id;

    private String name;

    private LocalDate date;

    private int voteCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantTo that = (RestaurantTo) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", voteCount=" + voteCount +
                '}';
    }
}
