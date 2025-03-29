package com.example.SeftOrderingRestaurant.Repositories;

import com.example.SeftOrderingRestaurant.Entities.Dishes;
import com.example.SeftOrderingRestaurant.Entities.DishIngredients;
import com.example.SeftOrderingRestaurant.Entities.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishIngredientsRepository extends JpaRepository<DishIngredients, Integer> {
    List<DishIngredients> findByDish(Dishes dish);
    List<DishIngredients> findByIngredient(Ingredients ingredient);
}
