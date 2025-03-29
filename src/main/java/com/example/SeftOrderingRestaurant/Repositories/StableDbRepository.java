package com.example.SeftOrderingRestaurant.Repositories;

import com.example.SeftOrderingRestaurant.Entities.Stable_db;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StableDbRepository extends JpaRepository<Stable_db, Integer> {
    Optional<Stable_db> findByVersionKey(String versionKey);
}