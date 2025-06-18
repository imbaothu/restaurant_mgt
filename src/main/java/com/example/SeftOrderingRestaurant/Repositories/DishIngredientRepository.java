package com.example.SeftOrderingRestaurant.Repositories;

import com.example.SeftOrderingRestaurant.Entities.DishIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishIngredientRepository extends JpaRepository<DishIngredient, Long> {
    List<DishIngredient> findByDishId(Long dishId);
    List<DishIngredient> findByIngredientId(Long ingredientId);
} 