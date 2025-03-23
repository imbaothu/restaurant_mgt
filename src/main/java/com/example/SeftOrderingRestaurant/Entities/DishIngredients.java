package com.example.SeftOrderingRestaurant.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "DishIngredients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishIngredients {

    @Id
    @ManyToOne
    @JoinColumn(name = "Dish_ID", nullable = false)
    private Dishes dish;

    @Id
    @ManyToOne
    @JoinColumn(name = "Ingredient_ID", nullable = false)
    private Ingredients ingredient;

    @Column(name = "Quantity", precision = 10, scale = 2)
    private BigDecimal quantity;
}