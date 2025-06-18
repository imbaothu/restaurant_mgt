package com.example.SeftOrderingRestaurant.Repositories;

import com.example.SeftOrderingRestaurant.Entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {
} 