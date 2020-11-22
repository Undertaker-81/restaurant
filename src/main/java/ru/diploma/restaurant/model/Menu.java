package ru.diploma.restaurant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 * @author Panfilov Dmitriy
 * 18.11.2020
 */
@Getter
@Setter
@Entity
public class Menu {
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = Restaurant.START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Integer id;

    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private int idRestaurant;

    @JoinColumn(name = "dish_id", nullable = false)
    @NotNull
    private int idDish;

    @JoinColumn(name = "date", nullable = false)
    @NotNull
    private LocalDateTime dateMenu;

    public Menu(Integer id,@NotNull int idRestaurant, @NotNull int idDish, @NotNull LocalDateTime dateMenu) {
        this.id = id;
        this.idRestaurant = idRestaurant;
        this.idDish = idDish;
        this.dateMenu = dateMenu;
    }

    public Menu() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
