package ru.diploma.restaurant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "dish")
@NoArgsConstructor
public class Dish extends BaseEntity{


    @NotNull
    private String name;

    @NotNull
    private int price;
}
