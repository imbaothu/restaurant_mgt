package com.example.SeftOrderingRestaurant.Repositories;

import com.example.SeftOrderingRestaurant.Entities.Ingredients;
import com.example.SeftOrderingRestaurant.Enums.IngredientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {
    Optional<Ingredients> findByName(String name);
    List<Ingredients> findByNameContaining(String keyword);
    List<Ingredients> findByStatus(IngredientStatus status);
}