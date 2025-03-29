package com.example.SeftOrderingRestaurant.Repositories;

import com.example.SeftOrderingRestaurant.Entities.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Suppliers, Integer> {
    Optional<Suppliers> findByName(String name);
    List<Suppliers> findByNameContaining(String keyword);
    Optional<Suppliers> findByEmail(String email);
    Optional<Suppliers> findByPhone(String phone);
}
