package ru.diploma.restaurant.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "dish")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Dish extends BaseEntity{


    @NotNull
    private String name;

    @NotNull
    private int price;

    public Dish(Integer id, @NotNull String name, @NotNull int price) {
        super(id);
        this.name = name;
        this.price = price;
    }
}
