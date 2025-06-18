package com.example.SeftOrderingRestaurant.Repositories;

import com.example.SeftOrderingRestaurant.Entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByCategory(String category);
    List<Ingredient> findBySupplierId(Long supplierId);
} 