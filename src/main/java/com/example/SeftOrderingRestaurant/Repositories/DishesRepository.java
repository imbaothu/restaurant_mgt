package com.example.SeftOrderingRestaurant.Repositories;

import com.example.SeftOrderingRestaurant.Entities.Categories;
import com.example.SeftOrderingRestaurant.Entities.Dishes;
import com.example.SeftOrderingRestaurant.Enums.DishStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface DishesRepository extends JpaRepository<Dishes, Integer> {
    Optional<Dishes> findByName(String name);
    List<Dishes> findByCategory(Categories category);
    List<Dishes> findByStatus(DishStatus status);
    List<Dishes> findByPriceLessThanEqual(BigDecimal price);
}