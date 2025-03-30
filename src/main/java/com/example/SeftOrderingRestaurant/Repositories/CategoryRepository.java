package com.example.SeftOrderingRestaurant.Repositories;

import com.example.SeftOrderingRestaurant.Entities.Categories;
import com.example.SeftOrderingRestaurant.Enums.CategoryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {

    List<Categories> findByStatus(CategoryStatus status);

    Optional<Categories> findByName(String name);

    boolean existsByName(String name);
}
