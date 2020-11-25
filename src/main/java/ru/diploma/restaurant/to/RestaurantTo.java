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

@Getter
@Setter
public class RestaurantTo {



    private String name;

    private LocalDate date;

    private int voteCount;

    public RestaurantTo(String name, LocalDate date, int voteCount) {
        this.name = name;
        this.date = date;
        this.voteCount = voteCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantTo that = (RestaurantTo) o;
        return voteCount == that.voteCount &&
                Objects.equals(name, that.name) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date, voteCount);
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", voteCount=" + voteCount +
                '}';
    }
}
