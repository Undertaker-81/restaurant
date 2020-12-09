package ru.diploma.restaurant.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Panfilov Dmitriy
 * 18.11.2020
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@Table(name = "menu")
public class Menu extends BaseEntity  {

    @NotNull
    @Column(name = "restaurant_id", nullable = false)
    private int restaurantId;

    @NotNull
    @Column(name = "dish_id", nullable = false)
    private int idDish;

    @Column(name = "menu_date", nullable = false)
    @NotNull
    private LocalDate dateMenu;

    public Menu(Integer id, @NotNull int restaurantId, @NotNull int idDish, @NotNull LocalDate dateMenu) {
        super(id);
        this.restaurantId = restaurantId;
        this.idDish = idDish;
        this.dateMenu = dateMenu;
    }
}

